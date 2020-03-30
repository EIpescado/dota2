package pers.yurwisher.dota2.third.qiniu;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pers.yurwisher.earthshaker.service.IQiniuService;
import pers.yurwisher.earthshaker.service.impl.QiniuServiceImpl;
import pers.yurwisher.earthshaker.support.QiniuConfig;

/**
 * @author yq
 * @date 2019/08/09 08:53
 * @description 七牛配置
 * @since V1.0.0
 */
@Configuration
public class QiniuConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "yurwisher.qiniu")
    public QiniuConfig qiniuConfig(){
        return new QiniuConfig();
    }

    @Bean
    public IQiniuService qiniuService(QiniuConfig qiniuConfig){
        return new QiniuServiceImpl(qiniuConfig);
    }
}
