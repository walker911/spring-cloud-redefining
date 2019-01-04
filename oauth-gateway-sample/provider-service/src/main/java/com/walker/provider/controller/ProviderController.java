package com.walker.provider.controller;

import com.walker.core.context.UserContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author walker
 * @date 2019/1/3
 */
@RestController
public class ProviderController {

    @GetMapping("/provider/test")
    public String test(HttpServletRequest request) {
        System.out.println("auth success, the user is: " + UserContextHolder.currentUser().getUsername());
        System.out.println("----------success access provider service-----------");
        return "success access provider service";
    }
}
