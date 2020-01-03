package com.walker.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * <p>
 *
 * name: 用于服务发现
 * url: 绝对路径，一般用于调试
 * decode404: 当发生404时，若为true, 会调用decoder进行解码，否则抛出异常
 * path: 统一前缀
 * configuration: 配置类，可自定义Encoder, Decoder, LogLevel
 * fallback: 定义容错的处理类
 * fallbackFactory: 工厂类， 定义通用容错逻辑
 * primary:
 *
 * </p>
 *
 * @author mu qin
 * @date 2020/1/3
 */
@FeignClient(name = "settle-income-service", path = "/settle-income-service")
public interface IncomeFeignClient {

    @PostMapping("/pre/query")
    String preQuery();

}
