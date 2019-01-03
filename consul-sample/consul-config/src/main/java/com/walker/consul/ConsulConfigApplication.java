package com.walker.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author walker
 * @date 2019/1/3
 */
@RefreshScope
@SpringBootApplication
public class ConsulConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulConfigApplication.class, args);
    }
}
