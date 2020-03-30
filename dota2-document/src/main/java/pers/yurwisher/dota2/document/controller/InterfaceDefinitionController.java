package pers.yurwisher.dota2.document.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.yurwisher.dota2.common.base.BaseController;
import pers.yurwisher.dota2.document.pojo.fo.InterfaceDefinitionFo;
import pers.yurwisher.dota2.document.pojo.qo.InterfaceDefinitionQo;
import pers.yurwisher.dota2.document.service.IInterfaceDefinitionService;
import pers.yurwisher.wisp.wrapper.R;

/**
 * @author yq
 * @date 2019-11-26 14:20:01
 * @description 接口定义
 * @since V1.0.0
 */
@RestController
@RequestMapping("/interfaceDefinition")
public class InterfaceDefinitionController extends BaseController {
    private IInterfaceDefinitionService interfaceDefinitionService;

    public InterfaceDefinitionController(IInterfaceDefinitionService interfaceDefinitionService) {
        this.interfaceDefinitionService = interfaceDefinitionService;
    }

    @PostMapping
    public R create(@RequestBody InterfaceDefinitionFo fo){
        interfaceDefinitionService.create(fo);
        return R.ok();
    }

    @PostMapping("{id}")
    public R update(@PathVariable(name = "id")Long id, @RequestBody InterfaceDefinitionFo fo){
        interfaceDefinitionService.update(id,fo);
        return R.ok();
    }

    @GetMapping("{id}")
    public R get(@PathVariable(name = "id")Long id){
        return R.ok(interfaceDefinitionService.get(id));
    }

    @GetMapping
    public R list(@ModelAttribute InterfaceDefinitionQo qo){
        return R.ok(interfaceDefinitionService.list(qo));
    }

    @GetMapping("tree")
    public R interfaceMap(){
        return R.ok(interfaceDefinitionService.interfaceMap());
    }

}
