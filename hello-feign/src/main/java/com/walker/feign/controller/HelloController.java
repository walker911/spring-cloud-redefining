package com.walker.feign.controller;

import com.walker.feign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author walker
 * @date 2018/12/25
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping(value = "/search/github")
    public String searchRepositories(@RequestParam("str") String queryStr) {
        return helloService.searchRepository(queryStr);
    }
}
