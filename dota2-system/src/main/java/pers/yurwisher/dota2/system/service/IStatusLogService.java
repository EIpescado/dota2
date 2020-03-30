package pers.yurwisher.dota2.system.service;

import pers.yurwisher.dota2.common.base.BaseService;
import pers.yurwisher.dota2.system.entity.StatusLog;
import pers.yurwisher.dota2.system.pojo.qo.StatusLogQo;
import pers.yurwisher.dota2.system.pojo.to.StatusLogTo;
import pers.yurwisher.wisp.wrapper.PageR;


/**
 * @author yq
 * @date 2019-11-11 22:29:20
 * @description 状态日志
 * @since V1.0.0
 */
public interface IStatusLogService extends BaseService<StatusLog> {

    /**
     * 创建状态日志
     * @param entityId 实体ID
     * @param clazz 实体类
     * @param status 状态
     * @param remark 备注
     */
    void create(Long entityId, Class clazz, String status, String remark);

    /**
     * 创建状态日志
     * @param entityId 实体ID
     * @param clazz 实体类
     * @param status 状态
     */
    void create(Long entityId, Class clazz, String status);

    /**
     * 分页
     * @param qo 查询参数
     * @return 分页结果
     */
    PageR<StatusLogTo> list(StatusLogQo qo);
}
