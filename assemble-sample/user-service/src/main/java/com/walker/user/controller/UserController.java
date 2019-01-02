package com.walker.user.controller;

import com.walker.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author walker
 * @date 2019/1/2
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getContextUserId")
    public String getContextUserId() {
        return userService.getContextUserId();
    }

    @GetMapping("/getDefaultUser")
    public String getDefaultUser() {
        return userService.getDefaultUser();
    }

    @GetMapping("/getProvider")
    public List<String> getProviderData() {
        return userService.getProviderData();
    }
}
