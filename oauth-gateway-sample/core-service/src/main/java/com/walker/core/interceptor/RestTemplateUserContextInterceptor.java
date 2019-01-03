package com.walker.core.interceptor;

import com.walker.core.context.UserContextHolder;
import com.walker.core.vo.User;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * @author walker
 * @date 2019/1/3
 */
public class RestTemplateUserContextInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        User user = UserContextHolder.currentUser();
        httpRequest.getHeaders().add("x-user-id",user.getUserId());
        httpRequest.getHeaders().add("x-user-name",user.getUsername());
        httpRequest.getHeaders().add("x-user-serviceName",httpRequest.getURI().getHost());
        return clientHttpRequestExecution.execute(httpRequest, bytes);
    }
}
