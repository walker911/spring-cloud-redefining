package com.walker.core.context;

import com.walker.core.vo.User;

/**
 * @author walker
 * @date 2019/1/3
 */
public class UserContextHolder {

    public static ThreadLocal<User> context = new ThreadLocal<>();

    public static User currentUser() {
        return context.get();
    }

    public static void set(User user) {
        context.set(user);
    }

    public static void shutdown() {
        context.remove();
    }
}
