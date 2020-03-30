package pers.yurwisher.dota2.common.wrapper;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yq
 * @date 2019/07/18 14:53
 * @description 返回给前端的验证码对象
 * @since V1.0.0
 */
@Data
public class ValidCode implements Serializable {
    private static final long serialVersionUID = 5558137110045910823L;

    public ValidCode(String byteImg, String uuid) {
        this.byteImg = byteImg;
        this.uuid = uuid;
    }

    /**
     * 验证码二进制字节码
     */
    private String byteImg;
    /**
     * 验证码对应UUID
     */
    private String uuid;
}
