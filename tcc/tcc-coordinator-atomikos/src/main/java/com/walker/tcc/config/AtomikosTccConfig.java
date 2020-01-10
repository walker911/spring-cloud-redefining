package com.walker.tcc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * <p>
 *
 * </p>
 *
 * @author mu qin
 * @date 2020/1/9
 */
@Configuration
public class AtomikosTccConfig {

    @Bean
    public AtomikosTccSpringAdapter atomikosTccSpringAdapter() {
        return new AtomikosTccSpringAdapter();
    }

    /**
     * 通过@PostConstruct及@PreDestroy将atomikos的Configuration纳入spring
     * 容器的生命周期管理中，进行初始化及销毁相关动作
     *
     */
    public static class AtomikosTccSpringAdapter {

        @PostConstruct
        public void start() {
            com.atomikos.icatch.config.Configuration.init();
        }

        @PreDestroy
        public void shutdown() {
            com.atomikos.icatch.config.Configuration.shutdown(false);
        }

    }
}
