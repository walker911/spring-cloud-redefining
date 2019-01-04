package com.walker.client;

import com.walker.grpc.HelloRequest;
import com.walker.grpc.HelloResponse;
import com.walker.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author walker
 * @date 2019/1/4
 */
public class GrpcClient {
    public static void main(String[] args) {
        // 创建 channel
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8082)
                .usePlaintext()
                .build();
        // 创建blocking stub
        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);
        // 发送消息
        HelloResponse response = stub.hello(HelloRequest.newBuilder()
                .setName("walker")
                .setAge(17)
                .addHobbies("football")
                .putTags("how?", "wonderful")
                .build());
        System.out.println(response);
        channel.shutdown();
    }
}
