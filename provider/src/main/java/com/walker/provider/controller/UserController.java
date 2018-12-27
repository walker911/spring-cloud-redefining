package com.walker.provider.controller;

import com.walker.provider.model.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author walker
 * @date 2018/12/26
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/add")
    public String addUser(User user) {
        return "hello, " + user.getUsername();
    }

    @PostMapping("/update")
    public String updateUser(@RequestBody User user) {
        return "hello, " + user.getUsername();
    }
}
