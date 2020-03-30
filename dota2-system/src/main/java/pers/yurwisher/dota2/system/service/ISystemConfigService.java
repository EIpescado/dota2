package pers.yurwisher.dota2.system.service;

import pers.yurwisher.dota2.common.base.BaseService;
import pers.yurwisher.dota2.system.entity.SystemConfig;
import pers.yurwisher.dota2.system.pojo.fo.SystemConfigFo;
import pers.yurwisher.dota2.system.pojo.qo.SystemConfigQo;
import pers.yurwisher.dota2.system.pojo.vo.SystemConfigVo;
import pers.yurwisher.wisp.wrapper.PageR;

/**
 * <p>
 * 系统配置 服务类
 * </p>
 *
 * @author yq
 * @since 2018-12-04
 */
public interface ISystemConfigService extends BaseService<SystemConfig> {

    /**
     * 系统配置
     * @param qo 查询参数
     * @return PageR 集合
     */
    PageR list(SystemConfigQo qo);

    /**
     * 根据编码获取配置值
     * @param code 编码
     * @return 配置值
     */
    String getValByCode(String code);

    /**
     * 新增
     * @param fo 参数
     */
    void create(SystemConfigFo fo);

    /**
     * 更新
     * @param id 主键
     * @param fo 参数
     */
    void update(Long id, SystemConfigFo fo);

    /**
     * 详情
     * @param id 主键
     * @return ButtonVo
     */
    SystemConfigVo get(Long id);

    /**
     * 根据编码获取系统配置
     * @param code 编码
     * @return 配置
     */
    SystemConfig findByCode(String code);

    /**
     * 根据编码更新配置
     * @param code 编码
     * @param value 值
     */
    void updateByCode(String code, String value);

}
