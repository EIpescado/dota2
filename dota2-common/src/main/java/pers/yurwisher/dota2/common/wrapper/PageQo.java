package pers.yurwisher.dota2.common.wrapper;

import lombok.Data;
import java.io.Serializable;

/**
 * @author yq
 * @date 2018/11/15 15:51
 * @description 基础分页查询对象
 * @since V1.0.0
 */
@Data
public class PageQo implements Serializable {

    private static final long serialVersionUID = 6216395881863744927L;
    /**
     * 页数
     */
    protected Long page = 1L;

    /**
     * 单页显示总条数
     */
    protected Long size = 5L;

    /**
     * 用户ID
     */
    private Long userId;

}
