package com.walker.user.service;

import java.util.List;

/**
 * @author walker
 * @date 2019/1/2
 */
public interface UserService {

    String getContextUserId();

    String getDefaultUser();

    List<String> getProviderData();
}
