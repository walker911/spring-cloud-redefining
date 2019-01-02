package com.walker.user.service.fallback;

import com.walker.user.service.feign.DataService;
import org.springframework.stereotype.Component;

/**
 * @author walker
 * @date 2019/1/2
 */
@Component
public class UserClientFallback implements DataService {

    @Override
    public String getContextUserId() {
        return "getContextUserId failed";
    }

    @Override
    public String getDefaultUser() {
        return "getDefaultUser failed";
    }
}
