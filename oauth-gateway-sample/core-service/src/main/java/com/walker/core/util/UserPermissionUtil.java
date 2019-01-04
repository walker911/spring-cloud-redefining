package com.walker.core.util;

import com.walker.core.vo.User;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author walker
 * @date 2019/1/4
 */
public class UserPermissionUtil {

    /**
     * 模拟权限校验
     *
     * @param user
     * @param request
     * @return
     */
    public static boolean verify(User user, HttpServletRequest request) {
        String url = request.getHeader("x-user-serviceName");
        if (StringUtils.isEmpty(user)) {
            return false;
        } else {
            List<String> allowPermissions = user.getAllowPermission();
            for (String str : allowPermissions) {
                if (url.equalsIgnoreCase(str)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 模拟权限赋值
     *
     * @param user
     */
    public static void permission(User user) {
        String username = user.getUsername();
        List<String> allowPermissions = new ArrayList<>();
        if ("admin".equals(username)) {
            allowPermissions.add("client-service");
            allowPermissions.add("provider-service");
        }
        if ("spring".equals(username)) {
            allowPermissions.add("client-service");
        }
        user.setAllowPermission(allowPermissions);
    }
}
