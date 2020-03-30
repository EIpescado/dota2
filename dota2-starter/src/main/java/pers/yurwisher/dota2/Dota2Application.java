package pers.yurwisher.dota2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author yq
 * @date 2019/07/10 17:15
 * @description 通用项目
 * @since V1.0.0
 */
@SpringBootApplication
@EnableCaching
public class Dota2Application {

    public static void main(String[] args) {
        SpringApplication.run(Dota2Application.class, args);
    }
}
