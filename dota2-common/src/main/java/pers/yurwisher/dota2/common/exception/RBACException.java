package pers.yurwisher.dota2.common.exception;

import pers.yurwisher.dota2.common.enums.tip.RBACCustomTipEnum;
import pers.yurwisher.wisp.exception.CustomException;

/**
 * @author yq
 * @date 2019/07/12 11:25
 * @description RBAC 异常
 * @since V1.0.0
 */
public class RBACException extends CustomException {

    private static final long serialVersionUID = -3195162779074887155L;

    public RBACException(RBACCustomTipEnum rbacCustomTipEnum) {
        super(rbacCustomTipEnum);
    }
}
