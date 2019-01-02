package com.walker.common.interceptor;

import com.walker.common.context.UserContextHolder;
import com.walker.common.vo.User;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.util.Map;

/**
 * @author walker
 * @date 2019/1/2
 */
public class RestTemplateUserContextInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        User user = UserContextHolder.currentUser();
        Map<String, String> headers = user.toHttpHeaders();
        headers.forEach((key, value) -> httpRequest.getHeaders().add(key, value));
        return clientHttpRequestExecution.execute(httpRequest, bytes);
    }
}
