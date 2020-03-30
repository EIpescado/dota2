package pers.yurwisher.dota2.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import pers.yurwisher.dota2.common.enums.tip.RBACCustomTipEnum;
import pers.yurwisher.dota2.common.utils.Utils;
import pers.yurwisher.dota2.common.wrapper.JWTUser;
import pers.yurwisher.dota2.common.wrapper.TokenPlus;
import pers.yurwisher.token.ITokenService;
import pers.yurwisher.token.exception.TokenException;
import pers.yurwisher.wisp.utils.StringUtils;
import pers.yurwisher.wisp.wrapper.R;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yq
 * @date 2019/07/15 11:24
 * @description jwt token拦截器
 * @since V1.0.0
 */
@Component
public class JwtAuthorizationTokenFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthorizationTokenFilter.class);

    private ITokenService<TokenPlus> tokenService;
    @Value("${yurwisher.token.header-name}")
    private String tokenHeaderName ;

    public JwtAuthorizationTokenFilter(ITokenService<TokenPlus> tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        //获取请求头中的token字符串
        final String tokenStr = request.getHeader(tokenHeaderName);
        if (StringUtils.isNotEmpty(tokenStr)) {
            TokenPlus token;
            try {
                token = tokenService.parseToken(tokenStr);
            } catch (TokenException e) {
                logger.info("token转化失败", e);
                Utils.responseJSON(response, RBACCustomTipEnum.BAD_CREDENTIALS);
                return;
            }
            if (StringUtils.isNotEmpty(token.getUserName()) && SecurityContextHolder.getContext().getAuthentication() == null) {
                //校验token有效性
                if (token.validate(token.getLastUpdatePassword())) {
                    //可刷新,返回刷新后的token,前端使用最新的token后再次请求之前接口
                    if(tokenService.canRefresh(token)){
                        Utils.responseJSON(response, R.ok(RBACCustomTipEnum.REFRESH_TOKEN,tokenService.refreshToken(token)));
                        return;
                    }
                    logger.debug("{} 请求 {}", token.getUserName(),request.getRequestURI());
                    //从token中获取信息
                    JWTUser user = token.toJWTUser();
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                } else {
                    Utils.responseJSON(response,RBACCustomTipEnum.LOGIN_EXPIRED);
                    return;
                }
            }
        }
        chain.doFilter(request, response);
    }

}
