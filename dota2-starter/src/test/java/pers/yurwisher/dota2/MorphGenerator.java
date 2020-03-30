package pers.yurwisher.dota2;

import pers.yurwisher.morph.support.Morph;

/**
 * @author yq
 * @date 2019/07/10 16:19
 * @description
 * @since V1.0.0
 */
public class MorphGenerator {

    public static void main(String[] args) {
        Morph morph = new Morph();
        morph.modelBuilder().setIdType("Long")
                .setAuthor("yq")
                .setModule("chaos-yulong")
                .setBasePackage("pers.yurwisher.chaos")
                .setEntityClass("pers.yurwisher.chaos.yulong.entity.Commission")
                .setDescription("提成");
        morph.configBuilder().setServiceSuperClass("pers.yurwisher.chaos.common.base.BaseService")
                .setSo(false).setVo(false).setTo(true).setQo(true).setFo(true)
                .setQoSuperClass("pers.yurwisher.chaos.common.wrapper.PageQo")
                .setMapperSuperClass("pers.yurwisher.chaos.common.base.CommonMapper")
                .setMapperLocation("mapper")
                .setServiceImplSuperClass("pers.yurwisher.chaos.common.base.impl.BaseServiceImpl")
                .setControllerSuperClass("pers.yurwisher.chaos.common.base.BaseController");
        morph.wave();
    }
}
