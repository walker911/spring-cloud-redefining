package com.walker.consumer.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author walker
 * @date 2018/12/26
 */
@Configuration
public class FeignLogConfig {

    @Bean
    public Logger.Level level() {
        return Logger.Level.FULL;
    }
}
