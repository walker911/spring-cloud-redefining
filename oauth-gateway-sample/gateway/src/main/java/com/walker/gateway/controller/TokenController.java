package com.walker.gateway.controller;

import com.walker.gateway.util.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author walker
 * @date 2019/1/4
 */
@RestController
public class TokenController {

    @GetMapping("/getToken/{name}")
    public String getToken(@PathVariable String name) {
        return JwtUtil.generateToken(name);
    }
}
