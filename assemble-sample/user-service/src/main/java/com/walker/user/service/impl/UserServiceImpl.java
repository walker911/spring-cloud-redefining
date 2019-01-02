package com.walker.user.service.impl;

import com.walker.user.service.UserService;
import com.walker.user.service.feign.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author walker
 * @date 2019/1/2
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private DataService dataService;
    @Lazy
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String getContextUserId() {
        return dataService.getContextUserId();
    }

    @Override
    public String getDefaultUser() {
        return dataService.getDefaultUser();
    }

    @Override
    public List<String> getProviderData() {
        List<String> result = restTemplate.getForObject("http://data-service/getProviderData", List.class);
        return result;
    }
}
