package pers.yurwisher.dota2.common.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpStatus;
import pers.yurwisher.wisp.constants.SymbolConstants;
import pers.yurwisher.wisp.enums.ICustomTipEnum;
import pers.yurwisher.wisp.utils.CodeUtils;
import pers.yurwisher.wisp.utils.CollectionUtils;
import pers.yurwisher.wisp.utils.StringUtils;
import pers.yurwisher.wisp.wrapper.R;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * @author yq
 * @date 2019/07/15 16:17
 * @description
 * @since V1.0.0
 */
public class Utils {

    private static final Pattern URL_PARAMS_PATTERN = Pattern.compile("\\{\\S+}$");

    private String x= "1";
    private static final String[] HEADERS_TO_TRY = {
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR",
            "HTTP_X_FORWARDED",
            "HTTP_X_CLUSTER_CLIENT_IP",
            "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR",
            "HTTP_FORWARDED",
            "HTTP_VIA",
            "REMOTE_ADDR",
            "X-Real-IP"
    };
    private static final String UN_KNOWN = "unknown";

    public static void responseJSON(HttpServletResponse response, R r) throws IOException {
        response.setStatus(HttpStatus.OK.value());
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().append(JSON.toJSONString(r));
        response.getWriter().flush();
        response.getWriter().close();
    }

    public static void responseJSON(HttpServletResponse response, ICustomTipEnum customTipEnum) throws IOException {
        response.setStatus(HttpStatus.OK.value());
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().append(JSON.toJSONString(R.fail(customTipEnum)));
    }

    /**
     * 加密密码
     *
     * @param password 密码
     * @return 加密后的密文
     */
    public static String encryptPassword(String password) {
        //密码 sha-256加密 转 Hex 大写
        return CodeUtils.sha256Hex(password);
    }

    /**
     * 请求是匹配
     *
     * @param regex 接口管理里面的配置请求地址
     * @param path  实际请求地址
     * @return 是否匹配
     */
    public static boolean matching(String regex, String path) {
        //将请求地址拆分成 单独的子路径
        String[] pathArray = path.split(SymbolConstants.SLASH);
        String[] regexArray = regex.split(SymbolConstants.SLASH);
        //比较路径分层是否一致
        if (pathArray.length == regexArray.length) {
            for (int i = 0; i < pathArray.length; i++) {
                String subPath = pathArray[i];
                String subRegex = regexArray[i];
                //此子路径为url参数,即包含{id}这类
                if (URL_PARAMS_PATTERN.matcher(subRegex).find()) {
                    //只要实际请求路径对应参数不为空即算满足匹配
                    if (StringUtils.isEmpty(subPath)) {
                        return false;
                    }
                } else {
                    //子路径不一致
                    if (!subPath.equals(subRegex)) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String getQueryId(Long receiverId, Long senderId) {
        Long[] ids = new Long[]{receiverId, senderId};
        Arrays.sort(ids);
        return new StringBuilder(ids[0].toString()).append("_").append(ids[1]).toString();
    }

    /**
     * 根据请求获取用户ip 取第一个非unknown的ip,穿透代理
     *
     * @param request 请求
     */
    public static String getIp(HttpServletRequest request) {
        String ip = "";
        for (String head : HEADERS_TO_TRY) {
            ip = request.getHeader(head);
            if (StringUtils.isNotEmpty(ip) && !UN_KNOWN.equalsIgnoreCase(ip)) {
                break;
            }
        }
        return StringUtils.isEmpty(ip) ? request.getRemoteAddr() : ip;
    }

    /**
     * 格式化字符串
     * 例子  吃饭:paramName块
     * @param template 模版
     * @param map 参数
     * @return 格式化后结果
     */
    public static String format(String template, Map<String, Object> map) {
        if(CollectionUtils.isNotEmpty(map)){
            String result = template ;
            for(Map.Entry<String,Object> entry : map.entrySet()){
                result = result.replaceAll(SymbolConstants.COLON + entry.getKey(),StringUtils.null2EmptyWithTrimNew(entry.getValue()));
            }
            return result;
        }
        return template;
    }

    public static Long parseLong(String value){
        if (StringUtils.isNotEmpty(value)){
           return Long.parseLong(value);
        }
        return null;
    }

    public static Integer parseInteger(String value){
        if (StringUtils.isNotEmpty(value)){
            return Integer.parseInt(value);
        }
        return null;
    }

    /**
     * 获取文件类型
     * @param fileName 文件名称
     * @return 文件类型
     */
    public static String getFileType(String fileName){
        if(fileName != null && fileName.length() > 0 && fileName.contains(SymbolConstants.DOT)){
            return fileName.substring(fileName.lastIndexOf(SymbolConstants.DOT) + 1);
        }
        return "" ;
    }
}
