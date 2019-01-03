package com.walker.consul.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author walker
 * @date 2019/1/3
 */
@FeignClient(name = "consul-provider")
public interface ConsumerService {
    @GetMapping("/sayHello")
    String sayHello(@RequestParam("name") String name);
}
