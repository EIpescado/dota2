package pers.yurwisher.dota2.rbac.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.yurwisher.dota2.rbac.pojo.fo.DepartmentFo;
import pers.yurwisher.dota2.rbac.service.IDepartmentService;
import pers.yurwisher.dota2.common.base.BaseController;
import pers.yurwisher.wisp.wrapper.R;

/**
 * @author yq
 * @date 2019-07-22 17:11:02
 * @description 部门
 * @since V1.0.0
 */
@RestController
@RequestMapping("/department")
public class DepartmentController extends BaseController {
    private IDepartmentService departmentService;

    public DepartmentController(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public R create(@RequestBody DepartmentFo fo){
        departmentService.create(fo);
        return R.ok();
    }

    @PostMapping("{id}")
    public R update(@PathVariable(name = "id")Long id, @RequestBody DepartmentFo fo){
        departmentService.update(id,fo);
        return R.ok();
    }

    @GetMapping("{id}")
    public R get(@PathVariable(name = "id")Long id){
        return R.ok(departmentService.get(id));
    }

    @PostMapping("/delete/{id}")
    public R delete(@PathVariable(name = "id")Long id){
        departmentService.delete(id);
        return R.ok();
    }

    @GetMapping("tree")
    public R tree(){
        return R.ok(departmentService.tree());
    }
}
