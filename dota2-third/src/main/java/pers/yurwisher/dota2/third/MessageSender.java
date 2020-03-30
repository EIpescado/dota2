package pers.yurwisher.dota2.third;

/**
 * @author yq
 * @date 2019/12/18 11:44
 * @description 短信发送, 通用接口,按对接的第三方自定义实现
 * @since V1.0.0
 */
public interface MessageSender {

    /**
     * 发送短信
     * @param content 短信内容
     * @param phones 手机号多个
     */
    void sendMessage(String content, String... phones);

}
