package com.walker.feign;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * EnableFeignClients: 程序启动时，扫描所有带@FeignClient的类并处理
 *
 * @author walker
 * @date 2018/12/25
 */
@EnableFeignClients
@SpringBootApplication
public class FeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }

    @Bean
    public Logger.Level level() {
        return Logger.Level.FULL;
    }
}
