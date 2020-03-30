package pers.yurwisher.dota2.common.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import pers.yurwisher.dota2.common.wrapper.PageQo;
import pers.yurwisher.wisp.wrapper.PageR;


/**
 * @author yq
 * @date 2018/04/11 16:06
 */
public interface BaseService<T> extends IService<T>{


    /**
     * 自定义分页参数转 mybatis-plus分页参数
     * @param qo 查询参数
     */
    Page toPage(PageQo qo);

    /**
     * mybatis-plus 分页结果转自定义结果
     * @param page mybatis-plus 分页结果
     */
    PageR toPageR(IPage page);

}
