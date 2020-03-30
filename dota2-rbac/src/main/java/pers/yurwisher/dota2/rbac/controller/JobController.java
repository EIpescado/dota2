package pers.yurwisher.dota2.rbac.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import pers.yurwisher.dota2.common.base.BaseController;
import pers.yurwisher.wisp.wrapper.R;
import pers.yurwisher.dota2.rbac.pojo.fo.JobFo;
import pers.yurwisher.dota2.rbac.pojo.qo.JobQo;
import pers.yurwisher.dota2.rbac.service.IJobService;

/**
 * @author yq
 * @date 2019-07-22 17:30:48
 * @description 职位
 * @since V1.0.0
 */
@RestController
@RequestMapping("/job")
public class JobController extends BaseController {
    private IJobService jobService;

    public JobController(IJobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public R create(@RequestBody JobFo fo){
        jobService.create(fo);
        return R.ok();
    }

    @PostMapping("{id}")
    public R update(@PathVariable(name = "id")Long id, @RequestBody JobFo fo){
        jobService.update(id,fo);
        return R.ok();
    }

    @GetMapping("{id}")
    public R get(@PathVariable(name = "id")Long id){
        return R.ok(jobService.get(id));
    }

    @PostMapping("/delete/{id}")
    public R delete(@PathVariable(name = "id")Long id){
        jobService.delete(id);
        return R.ok();
    }

    @GetMapping
    public R list(@ModelAttribute JobQo qo){
        return R.ok(jobService.list(qo));
    }

    @GetMapping("select")
    public R select(@RequestParam("departmentId")Long departmentId){
        return R.ok(jobService.select(departmentId));
    }

}
