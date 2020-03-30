package pers.yurwisher.dota2.rbac.mapper;

import org.apache.ibatis.annotations.Param;
import pers.yurwisher.dota2.common.base.CommonMapper;
import pers.yurwisher.dota2.rbac.entity.Department;
import pers.yurwisher.dota2.rbac.pojo.dto.DepartmentNode;
import pers.yurwisher.dota2.rbac.pojo.vo.DepartmentVo;

import java.util.List;

/**
 * @author yq
 * @date 2019-07-22 17:11:02
 * @description 部门 Mapper
 * @since V1.0.0
 */
public interface DepartmentMapper extends CommonMapper<Department> {

    /**
    * 详情
    * @param id ID
    * @return 详情
    */
    DepartmentVo get(@Param("id")Long id);

    /**
     * 所有部门
     * @return 部门集合
     */
    List<DepartmentNode> findAll();
}
