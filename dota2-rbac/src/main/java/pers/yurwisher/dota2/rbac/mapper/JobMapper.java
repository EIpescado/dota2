package pers.yurwisher.dota2.rbac.mapper;

import pers.yurwisher.dota2.common.base.CommonMapper;
import pers.yurwisher.dota2.rbac.entity.Job;
import pers.yurwisher.dota2.rbac.pojo.qo.JobQo;
import pers.yurwisher.dota2.rbac.pojo.to.JobTo;
import pers.yurwisher.dota2.rbac.pojo.vo.JobVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import pers.yurwisher.wisp.wrapper.So;

import java.util.List;

/**
 * @author yq
 * @date 2019-07-22 17:30:48
 * @description 部门 Mapper
 * @since V1.0.0
 */
public interface JobMapper extends CommonMapper<Job> {

    /**
     * 列表
     * @param page mybatis-plus分页参数
     * @param qo 查询参数
     * @return 列表
     */
    IPage<JobTo> list(Page page, @Param("qo") JobQo qo);

    /**
    * 详情
    * @param id ID
    * @return 详情
    */
    JobVo get(@Param("id")Long id);

    /**
     * 职位下拉框
     * @param departmentId 部门
     * @return 集合
     */
    List<So<Long>> select(@Param("departmentId")Long departmentId);
}
