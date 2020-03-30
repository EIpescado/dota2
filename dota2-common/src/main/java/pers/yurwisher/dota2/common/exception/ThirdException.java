package pers.yurwisher.dota2.common.exception;

import pers.yurwisher.dota2.common.enums.tip.ThirdCustomTipEnum;
import pers.yurwisher.wisp.exception.CustomException;

/**
 * @author yq
 * @date 2019/10/15 14:50
 * @description 第三方接口 异常
 * @since V1.0.0
 */
public class ThirdException extends CustomException {
    private static final long serialVersionUID = -4945449780997758573L;

    public ThirdException(ThirdCustomTipEnum customTipEnum) {
        super(customTipEnum);
    }
}
