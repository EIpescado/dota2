package pers.yurwisher.dota2.system.pojo.vo;

import lombok.Data;

/**
 * @author yq
 * @date 2019/08/19 17:28
 * @description 未读消息数量汇总
 * @since V1.0.0
 */
@Data
public class UnReadMessage {

    private Boolean unReadFlag;
    private Integer web;
    private Integer system;

    public UnReadMessage(Integer web, Integer system) {
        this.web = web;
        this.system = system;
        this.unReadFlag = web > 0 || system > 0 ;
    }
}
