package pers.yurwisher.dota2.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import pers.yurwisher.dota2.common.base.CommonMapper;
import pers.yurwisher.dota2.system.entity.EnterprisePortalInfo;
import pers.yurwisher.dota2.system.pojo.qo.EnterprisePortalInfoQo;
import pers.yurwisher.dota2.system.pojo.to.EnterprisePortalInfoTo;

/**
 * @author yq
 * @date 2019-10-31 09:19:05
 * @description 企业门户信息配置 Mapper
 * @since V1.0.0
 */
public interface EnterprisePortalInfoMapper extends CommonMapper<EnterprisePortalInfo> {

    /**
     * 分页查询
     * @param toPage mybatis-plus分页插件
     * @param qo 查询参数
     * @return 分页结果
     */
    IPage<EnterprisePortalInfoTo> list(Page toPage, @Param("qo") EnterprisePortalInfoQo qo);

    /**
     * 更新激活状态 id != id
     * @param activated boolean
     * @param id ID
     */
    void updateActivateWhichIdNotEqual(@Param("activated") Boolean activated, @Param("id") Long id);
}
