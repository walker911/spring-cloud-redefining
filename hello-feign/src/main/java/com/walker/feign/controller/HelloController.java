package com.walker.feign.controller;

import com.walker.feign.service.HelloService;
import com.walker.feign.service.IncomeFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author walker
 * @date 2018/12/25
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HelloController {

    private final HelloService helloService;
    private final IncomeFeignClient incomeFeignClient;

    @GetMapping(value = "/search/github")
    public String searchRepositories(@RequestParam("str") String queryStr) {
        return helloService.searchRepository(queryStr);
    }

    @GetMapping(value = "/query")
    public String query() {
        return incomeFeignClient.preQuery();
    }
}
