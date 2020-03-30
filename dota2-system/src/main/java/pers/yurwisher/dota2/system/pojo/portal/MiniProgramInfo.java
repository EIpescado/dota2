package pers.yurwisher.dota2.system.pojo.portal;

import lombok.Data;

import java.util.List;

/**
 * @author yq
 * @date 2019/12/12 14:30
 * @description 小程序需要的配置信息
 * @since V1.0.0
 */
@Data
public class MiniProgramInfo {

    /**
     * 走马灯
     */
    private List<Carousel> carousels;

    private OnlineServiceInfo onlineServiceInfo;
}
