package pers.yurwisher.dota2.common.base.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pers.yurwisher.dota2.common.base.BaseService;
import pers.yurwisher.dota2.common.wrapper.PageQo;
import pers.yurwisher.wisp.wrapper.PageR;


/**
 * @author yq
 * @date 2018/11/15 11:39
 * @description 基础实现
 * @since V1.0.0
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected LambdaQueryWrapper<T> buildLambdaQueryWrapper(){
        return new LambdaQueryWrapper<>();
    }

    /**
     * 自定义分页参数转 mybatis-plus分页参数
     */
    @Override
    public Page toPage(PageQo qo){
        Page page = new Page();
        page.setSize(qo.getSize());
        page.setCurrent(qo.getPage());
        return page;
    }

    /**
     * mybatis-plus 分页结果转自定义结果
     */
    @Override
    @SuppressWarnings("unchecked")
    public PageR toPageR(IPage page){
        PageR pageR = new PageR<>();
        pageR.setPages(page.getPages());
        pageR.setTotal(page.getTotal());
        pageR.setRows(page.getRecords());
        return pageR;
    }

}
