package com.walker.core.interceptor;

import com.walker.core.context.UserContextHolder;
import com.walker.core.util.UserPermissionUtil;
import com.walker.core.vo.User;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author walker
 * @date 2019/1/3
 */
public class UserContextInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = getUser(request);
        // 模拟权限赋值
        UserPermissionUtil.permission(user);
        // 模拟权限校验
        if (!UserPermissionUtil.verify(user, request)) {
            response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
            PrintWriter writer = response.getWriter();
            writer.write("no permission access service, please check");
            writer.flush();
            writer.close();
            return false;
        }
        UserContextHolder.set(user);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserContextHolder.shutdown();
    }

    private User getUser(HttpServletRequest request) {
        String userId = request.getHeader("x-user-id");
        String username = request.getHeader("x-user-name");
        User user = new User();
        user.setUserId(userId);
        user.setUsername(username);
        return user;
    }
}
