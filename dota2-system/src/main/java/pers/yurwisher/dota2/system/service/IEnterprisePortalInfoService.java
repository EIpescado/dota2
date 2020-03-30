package pers.yurwisher.dota2.system.service;

import pers.yurwisher.dota2.common.base.BaseService;
import pers.yurwisher.dota2.system.entity.EnterprisePortalInfo;
import pers.yurwisher.dota2.system.pojo.fo.EnterprisePortalInfoFo;
import pers.yurwisher.dota2.system.pojo.qo.EnterprisePortalInfoQo;
import pers.yurwisher.dota2.system.pojo.to.EnterprisePortalInfoTo;
import pers.yurwisher.wisp.wrapper.PageR;


/**
 * @author yq
 * @date 2019-10-31 09:19:05
 * @description 企业门户信息配置
 * @since V1.0.0
 */
public interface IEnterprisePortalInfoService extends BaseService<EnterprisePortalInfo> {

    /**
     * 分页查询
     * @param qo 参数
     * @return 列表
     */
    PageR<EnterprisePortalInfoTo> list(EnterprisePortalInfoQo qo);

    /**
     * 变更门户信息
     * @param id EnterprisePortalInfo ID
     * @param fo 门户信息
     */
    void update(Long id, EnterprisePortalInfoFo fo);

    /**
     * 创建门户信息
     * @param fo 门户信息
     */
    void create(EnterprisePortalInfoFo fo);

    /**
     * 激活配置
     * @param id ID
     */
    void activate(Long id);

}
