package pers.yurwisher.dota2.common.exception;

import pers.yurwisher.dota2.common.enums.tip.SystemCustomTipEnum;
import pers.yurwisher.wisp.exception.CustomException;

/**
 * @author yq
 * @date 2019/10/15 14:50
 * @description 系统管理 异常
 * @since V1.0.0
 */
public class SystemException extends CustomException {
    private static final long serialVersionUID = -4945449780997758573L;

    public SystemException(SystemCustomTipEnum customTipEnum) {
        super(customTipEnum);
    }
}
