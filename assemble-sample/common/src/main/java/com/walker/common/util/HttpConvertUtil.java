package com.walker.common.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author walker
 * @date 2019/1/2
 */
public class HttpConvertUtil {

    public static Map<String, String> httpRequestToMap(HttpServletRequest request) {
        Enumeration<String> headers = request.getHeaderNames();
        Map<String, String> params = new HashMap<>();
        while (headers.hasMoreElements()) {
            String headerName = headers.nextElement();
            params.put(headerName, request.getHeader(headerName));
        }
        return params;
    }
}
