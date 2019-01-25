package com.walker.nacos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author walker
 * @date 2019/1/25
 */
@RestController
public class EchoController {
    @GetMapping("/echo/{name}")
    public Map<String, String> echo(@PathVariable String name) {
        Map<String, String> params = new HashMap<>();
        params.put("status", "success");
        params.put("name", name);
        return params;
    }
}
