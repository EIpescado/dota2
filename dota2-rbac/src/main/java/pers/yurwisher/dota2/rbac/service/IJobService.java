package pers.yurwisher.dota2.rbac.service;

import pers.yurwisher.dota2.common.base.BaseService;
import pers.yurwisher.dota2.rbac.entity.Job;
import pers.yurwisher.dota2.rbac.pojo.fo.JobFo;
import pers.yurwisher.dota2.rbac.pojo.qo.JobQo;
import pers.yurwisher.dota2.rbac.pojo.to.JobTo;
import pers.yurwisher.dota2.rbac.pojo.vo.JobVo;
import pers.yurwisher.wisp.wrapper.PageR;
import pers.yurwisher.wisp.wrapper.So;

import java.util.List;


/**
 * @author yq
 * @date 2019-07-22 17:30:48
 * @description 职位
 * @since V1.0.0
 */
public interface IJobService extends BaseService<Job> {

    /**
     * 新增
     * @param fo 参数
     */
    void create(JobFo fo);

    /**
     * 更新
     * @param id 主键
     * @param fo 参数
     */
    void update(Long id,JobFo fo);

    /**
     * 列表
     * @param qo 查询参数
     * @return 分页对象
     */
    PageR<JobTo> list(JobQo qo);


    /**
    * 详情
    * @param id 主键
    * @return JobVo
    */
    JobVo get(Long id);

     /**
     * 删除
     * @param id 主键
     */
    void delete(Long id);

    /**
     * 职位下拉框
     * @param departmentId  部门id
     * @return 职位下拉框
     */
    List<So<Long>> select(Long departmentId);
}
