package pers.yurwisher.dota2.system.pojo.qo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pers.yurwisher.dota2.common.wrapper.PageQo;

/**
 * @author yq
 * @date 2019/05/21 17:01
 * @description 系统配置Qo
 * @since V1.0.0
 */
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SystemConfigQo extends PageQo {

    private static final long serialVersionUID = -1555526198846313221L;

    private String name;

    private String code;
}
