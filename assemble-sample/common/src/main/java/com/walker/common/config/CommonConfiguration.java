package com.walker.common.config;

import com.walker.common.context.AuthorizationConcurrencyStrategy;
import com.walker.common.interceptor.FeignUserContextInterceptor;
import com.walker.common.interceptor.RestTemplateUserContextInterceptor;
import com.walker.common.interceptor.UserContextInterceptor;
import feign.Feign;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author walker
 * @date 2019/1/2
 */
@EnableWebMvc
@Configuration
public class CommonConfiguration implements WebMvcConfigurer {

    @Bean
    public UserContextInterceptor userContextInterceptor() {
        return new UserContextInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userContextInterceptor());
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new RestTemplateUserContextInterceptor());
        return restTemplate;
    }

    @Bean
    @ConditionalOnClass(Feign.class)
    public FeignUserContextInterceptor feignUserContextInterceptor() {
        return new FeignUserContextInterceptor();
    }

    @Bean
    public AuthorizationConcurrencyStrategy concurrencyStrategy() {
        return new AuthorizationConcurrencyStrategy();
    }
}
