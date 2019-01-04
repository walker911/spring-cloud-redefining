package com.walker.gateway.filter;

import com.walker.gateway.exception.PermissionException;
import com.walker.gateway.util.JwtUtil;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Map;

/**
 * @author walker
 * @date 2019/1/3
 */
@Component
public class AuthFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        Route gatewayUrl = exchange.getRequiredAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
        URI uri = gatewayUrl.getUri();
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders header = request.getHeaders();
        String token = header.getFirst(JwtUtil.HEADER_AUTH);
        Map<String, String> userMap = JwtUtil.validateToken(token);
        ServerHttpRequest.Builder mutate = request.mutate();
        String user = userMap.get("user");
        if ("admin".equals(user) || "spring".equals(user) || "cloud".equals(user)) {
            mutate.header("x-user-id", userMap.get("id"));
            mutate.header("x-user-name", userMap.get("user"));
            mutate.header("x-user-serviceName", uri.getHost());
        } else {
            throw new PermissionException("user not exist, please check");
        }
        ServerHttpRequest buildRequest = mutate.build();
        return chain.filter(exchange.mutate().request(buildRequest).build());
    }
}
