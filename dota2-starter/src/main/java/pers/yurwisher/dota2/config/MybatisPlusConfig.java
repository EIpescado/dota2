package pers.yurwisher.dota2.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;


/**
 * @author yq
 * @date 2018/11/14 15:01
 * @description mybatis-plus config
 * @since V1.0.0
 */
@Configuration
@MapperScan(basePackages = "pers.yurwisher.dota2.*.mapper")
public class MybatisPlusConfig {

    /**
     * mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 性能分析拦截器，不建议生产使用
     */
//    @Bean
//    public PerformanceInterceptor performanceInterceptor(){
//        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
//        //格式化sql
////        performanceInterceptor.setFormat(true);
//        return performanceInterceptor;
//    }

    /**
     * 自动填充值
     */
    @Bean
    public MetaObjectHandler dota2MetaObjectHandler(){
        return new MetaObjectHandler() {
            @Override
            public void insertFill(MetaObject metaObject) {
                LocalDateTime now =  LocalDateTime.now();
                this.setFieldValByName("enabled", true, metaObject);
                this.setFieldValByName("dateCreated", now, metaObject);
                this.setFieldValByName("lastUpdated", now, metaObject);
            }

            @Override
            public void updateFill(MetaObject metaObject) {
                this.setFieldValByName("lastUpdated", LocalDateTime.now(), metaObject);
            }
        };
    }
}
