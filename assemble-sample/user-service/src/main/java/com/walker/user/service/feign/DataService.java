package com.walker.user.service.feign;

import com.walker.user.service.fallback.UserClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author walker
 * @date 2019/1/2
 */
@FeignClient(name = "data-service", fallback = UserClientFallback.class)
public interface DataService {

    @GetMapping("/getContextUserId")
    String getContextUserId();

    @GetMapping("/getDefaultUser")
    String getDefaultUser();
}
