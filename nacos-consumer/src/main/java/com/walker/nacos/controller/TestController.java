package com.walker.nacos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author walker
 * @date 2019/1/25
 */
@RestController
public class TestController {

    private final RestTemplate restTemplate;

    @Autowired
    public TestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/echo/{name}")
    public Object echo(@PathVariable String name) {
        return restTemplate.getForObject("http://nacos-provider/echo/" + name, Object.class);
    }
}
