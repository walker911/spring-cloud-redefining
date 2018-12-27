package com.walker.consumer.service;

import com.walker.consumer.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author walker
 * @date 2018/12/26
 */
@FeignClient(value = "provider", path = "/user")
public interface UserService {

    @GetMapping(value = "/add")
    String addUser(User user);

    @PostMapping("/update")
    String updateUser(@RequestBody User user);
}
