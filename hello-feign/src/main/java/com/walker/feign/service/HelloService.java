package com.walker.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author walker
 * @date 2018/12/25
 */
@FeignClient(name = "github-client", url = "https://api.github.com")
public interface HelloService {

    @GetMapping(value = "/search/repositories")
    String searchRepository(@RequestParam("q") String queryStr);
}
