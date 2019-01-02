package com.walker.common.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author walker
 * @date 2019/1/2
 */
public class User {
    private String userId;
    private String userName;

    public static final String CONTEXT_KEY_USERID = "x-custom-user";

    public User() {
    }

    public User(Map<String, String> headers) {
        this.userId = headers.get(CONTEXT_KEY_USERID);
    }

    public Map<String, String> toHttpHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put(CONTEXT_KEY_USERID, userId);
        return headers;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
