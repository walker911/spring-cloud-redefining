package com.walker.data.controller;

import com.walker.common.context.UserContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author walker
 * @date 2019/1/2
 */
@RestController
public class DataController {

    @GetMapping("/getContextUserId")
    public String getContextUserId() {
        return UserContextHolder.currentUser().getUserId();
    }

    @GetMapping("/getDefaultUser")
    public String getDefaultUser() {
        return "Spring Cloud";
    }

    @GetMapping("/getProviderData")
    public List<String> getProviderData() {
        List<String> provider = new ArrayList<>();
        provider.add("Beijing Company");
        provider.add("Shanghai Company");
        provider.add("Shenzhen Company");
        return provider;
    }
}
