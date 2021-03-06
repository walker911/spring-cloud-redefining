package com.walker.consul.controller;

import com.walker.consul.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author walker
 * @date 2019/1/3
 */
@RestController
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/actuator/health")
    public String health() {
        return "SUCCESS";
    }

    @GetMapping("/sayHello")
    public String sayHello(@RequestParam("name") String name) {
        return consumerService.sayHello(name);
    }
}
