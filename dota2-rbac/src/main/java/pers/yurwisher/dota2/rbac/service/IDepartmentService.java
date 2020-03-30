package pers.yurwisher.dota2.rbac.service;

import pers.yurwisher.dota2.common.base.BaseService;
import pers.yurwisher.dota2.rbac.entity.Department;
import pers.yurwisher.dota2.rbac.pojo.dto.DepartmentNode;
import pers.yurwisher.dota2.rbac.pojo.fo.DepartmentFo;
import pers.yurwisher.dota2.rbac.pojo.vo.DepartmentVo;

import java.util.List;


/**
 * @author yq
 * @date 2019-07-22 17:11:02
 * @description 部门
 * @since V1.0.0
 */
public interface IDepartmentService extends BaseService<Department> {

    /**
     * 新增
     * @param fo 参数
     */
    void create(DepartmentFo fo);

    /**
     * 更新
     * @param id 主键
     * @param fo 参数
     */
    void update(Long id,DepartmentFo fo);


    /**
    * 详情
    * @param id 主键
    * @return DepartmentVo
    */
    DepartmentVo get(Long id);

     /**
     * 删除
     * @param id 主键
     */
    void delete(Long id);

    /**
     * 部门树
     * @return 部门
     */
    List<DepartmentNode> tree();
}
