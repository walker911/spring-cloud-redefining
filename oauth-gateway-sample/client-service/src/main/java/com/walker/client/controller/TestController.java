package com.walker.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author walker
 * @date 2019/1/4
 */
@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public String test(HttpServletRequest request) {
        System.out.println("-------- success access test method ---------");
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String key = headers.nextElement();
            System.out.println(key + ": " + request.getHeader(key));
        }
        return "success access test method";
    }

    @GetMapping("/accessProvider")
    public String accessProvider(HttpServletRequest request) {
        String result = restTemplate.getForObject("http://provider-service/provider/test", String.class);
        return result;
    }
}
