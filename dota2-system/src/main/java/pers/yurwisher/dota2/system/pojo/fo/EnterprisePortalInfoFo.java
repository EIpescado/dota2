package pers.yurwisher.dota2.system.pojo.fo;

import lombok.Data;
import pers.yurwisher.dota2.system.pojo.portal.WebInfo;

import java.io.Serializable;

/**
 * @author yq
 * @date 2019/10/31 10:59
 * @description 企业门户配置fo
 * @since V1.0.0
 */
@Data
public class EnterprisePortalInfoFo implements Serializable {

    private static final long serialVersionUID = 7995723382756925977L;
    private WebInfo webInfo;

    private String remark;
}
