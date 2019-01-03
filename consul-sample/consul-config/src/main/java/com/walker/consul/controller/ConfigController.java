package com.walker.consul.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author walker
 * @date 2019/1/3
 */
@RestController
public class ConfigController {

    @Value("${foo.bar.name}")
    private String name;

    @GetMapping("/getName")
    public String getName() {
        return name;
    }
}
