package pers.yurwisher.dota2.rbac.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.yurwisher.dota2.rbac.pojo.fo.PermissionFo;
import pers.yurwisher.dota2.rbac.service.IPermissionService;
import pers.yurwisher.dota2.common.base.BaseController;
import pers.yurwisher.wisp.wrapper.R;

/**
 * @author yq
 * @date 2019-10-08 14:52:14
 * @description 权限
 * @since V1.0.0
 */
@RestController
@RequestMapping("/permission")
public class PermissionController extends BaseController {
    private IPermissionService permissionService;

    public PermissionController(IPermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @PostMapping
    public R create(@RequestBody PermissionFo fo){
        permissionService.create(fo);
        return R.ok();
    }

    @PostMapping("{id}")
    public R update(@PathVariable(name = "id")Long id, @RequestBody PermissionFo fo){
        permissionService.update(id,fo);
        return R.ok();
    }

    @GetMapping("{id}")
    public R get(@PathVariable(name = "id")Long id){
        return R.ok(permissionService.get(id));
    }

    @PostMapping("/delete/{id}")
    public R delete(@PathVariable(name = "id")Long id){
        permissionService.delete(id);
        return R.ok();
    }

    /**
     * 角色权限树
     */
    @GetMapping("tree")
    public R tree(@RequestParam Long roleId){
        return R.ok(permissionService.tree(roleId));
    }

    /**
     * 完整权限树
     */
    @GetMapping("fullTree")
    public R fullTree(){
        return R.ok(permissionService.fullTree());
    }
}
