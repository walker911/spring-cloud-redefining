package com.walker.consul.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author walker
 * @date 2019/1/3
 */
@RestController
public class ProviderController {

    @GetMapping("/actuator/health")
    public String health() {
        return "SUCCESS";
    }

    @GetMapping("/sayHello")
    public String sayHello(String name) {
        return "hello, " + name;
    }
}
