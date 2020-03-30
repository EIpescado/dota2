package pers.yurwisher.dota2.rbac.pojo.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.yurwisher.dota2.common.enums.ComponentTypeEnum;
import pers.yurwisher.wisp.wrapper.Node;

/**
 * @author yq
 * @date 2019/07/25 15:32
 * @description 数节点,用于给角色分配组件
 * @since V1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TreeNode extends Node<Long,TreeNode> {
    private String name;

    @JSONField(serialzeFeatures = SerializerFeature.WriteEnumUsingName)
    private ComponentTypeEnum type;

    private Integer rowNo;
}
