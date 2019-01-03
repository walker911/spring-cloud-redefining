package com.walker.core.vo;

import java.util.List;

/**
 * @author walker
 * @date 2019/1/3
 */
public class User {

    public static final String CONTEXT_KEY_USERID = "x-user-id";

    private String userId;

    private String username;

    private List<String> allowPermission;

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getAllowPermission() {
        return allowPermission;
    }

    public void setAllowPermission(List<String> allowPermission) {
        this.allowPermission = allowPermission;
    }
}
