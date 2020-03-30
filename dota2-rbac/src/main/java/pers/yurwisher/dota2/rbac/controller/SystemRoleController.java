package pers.yurwisher.dota2.rbac.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.yurwisher.dota2.rbac.pojo.dto.TreeNode;
import pers.yurwisher.dota2.rbac.pojo.fo.SystemRoleFo;
import pers.yurwisher.dota2.rbac.pojo.qo.SystemRoleQo;
import pers.yurwisher.dota2.rbac.service.ISystemRoleService;
import pers.yurwisher.dota2.common.base.BaseController;
import pers.yurwisher.wisp.wrapper.R;

import java.util.List;

/**
 * @author yq
 * @date 2019-07-11 16:38:43
 * @description 角色
 * @since V1.0.0
 */
@RestController
@RequestMapping("/role")
public class SystemRoleController extends BaseController {
    private ISystemRoleService systemRoleService;

    public SystemRoleController(ISystemRoleService systemRoleService) {
        this.systemRoleService = systemRoleService;
    }

    /**新增角色*/
    @PostMapping
    public R create(@RequestBody SystemRoleFo fo){
        systemRoleService.create(fo);
        return R.ok();
    }

    /**修改角色*/
    @PostMapping("{id}")
    public R update(@PathVariable(name = "id")Long id, @RequestBody SystemRoleFo fo){
        systemRoleService.update(id,fo);
        return R.ok();
    }

    /**角色详情*/
    @GetMapping("{id}")
    public R get(@PathVariable(name = "id")Long id){
        return R.ok(systemRoleService.get(id));
    }

    /**删除角色*/
    @PostMapping("/delete/{id}")
    public R delete(@PathVariable(name = "id")Long id){
        systemRoleService.delete(id);
        return R.ok();
    }

    /**角色列表*/
    @GetMapping
    public R list(@ModelAttribute SystemRoleQo qo){
        return R.ok(systemRoleService.list(qo));
    }

    /**角色下拉框*/
    @GetMapping("select")
    public R select(){
        return R.ok(systemRoleService.select());
    }

    /**
     * 单角色下所有组件id
     * @param id 角色id
     */
    @GetMapping("/{id}/mbs")
    public R singleRoleMenuAndButton(@PathVariable Long id){
        return R.ok(systemRoleService.singleRoleMenuAndButton(id));
    }

    /**
     * 绑定组件(菜单和按钮)
     * @param nodes 信息
     * @param id 角色id
     */
    @PostMapping("/{id}/bind")
    public R bind(@RequestBody List<TreeNode> nodes, @PathVariable Long id){
        systemRoleService.bindComponent(id,nodes);
        return R.ok();
    }

    /**
     * 绑定权限
     * @param permissionIds 权限Ids
     * @param id 角色id
     */
    @PostMapping("/{id}/bindPermission")
    public R bindPermission(@RequestBody List<Long> permissionIds, @PathVariable Long id){
        systemRoleService.bindPermission(id,permissionIds);
        return R.ok();
    }
}
