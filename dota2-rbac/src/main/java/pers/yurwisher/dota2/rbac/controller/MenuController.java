package pers.yurwisher.dota2.rbac.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.yurwisher.dota2.rbac.pojo.fo.MenuFo;
import pers.yurwisher.dota2.rbac.service.IMenuService;
import pers.yurwisher.dota2.common.base.BaseController;
import pers.yurwisher.dota2.common.wrapper.JWTUser;
import pers.yurwisher.wisp.wrapper.R;

import javax.annotation.security.PermitAll;

/**
 * @author yq
 * @date 2019-07-11 16:34:49
 * @description 菜单
 * @since V1.0.0
 */
@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController {
    private IMenuService menuService;

    public MenuController(IMenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping
    @PermitAll
    public R create(@RequestBody MenuFo fo){
        menuService.create(fo);
        return R.ok();
    }

    @PostMapping("{id}")
    public R update(@PathVariable(name = "id")Long id, @RequestBody MenuFo fo){
        menuService.update(id,fo);
        return R.ok();
    }

    @GetMapping("{id}")
    public R get(@PathVariable(name = "id")Long id){
        return R.ok(menuService.get(id));
    }

    @PostMapping("/delete/{id}")
    public R delete(@PathVariable(name = "id")Long id){
        menuService.delete(id);
        return R.ok();
    }

    /**
     * 用户的菜单树
     */
    @GetMapping("tree")
    public R tree(){
        return R.ok(menuService.tree(JWTUser.currentUserId()));
    }

    /**
     * 完整菜单树,用于分配菜单及按钮
     */
    @GetMapping("fullTree")
    public R fullTree(){
        return R.ok(menuService.fullTree());
    }

}
