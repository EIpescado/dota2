package pers.yurwisher.dota2.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import pers.yurwisher.dota2.common.enums.tip.RBACCustomTipEnum;
import pers.yurwisher.dota2.common.utils.Utils;
import pers.yurwisher.wisp.wrapper.R;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * @author yq
 * @date 2019/07/15 15:17
 * @description security 无凭证访问需凭证资源时回调
 * @since V1.0.0
 */
@Component
@Slf4j
public class JWTAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {
    private static final long serialVersionUID = 6045915740572053062L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        log.info("ip:{},request {} ,security error:{}", Utils.getIp(request), request.getRequestURI(),e.getMessage());
        Utils.responseJSON(response,R.fail(RBACCustomTipEnum.LOGIN_PLEASE));
    }
}
