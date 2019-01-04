package com.walker.server.service;

import com.walker.grpc.HelloRequest;
import com.walker.grpc.HelloResponse;
import com.walker.grpc.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

/**
 * @author walker
 * @date 2019/1/4
 */
public class HiService extends HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        System.out.println(request);

        String greeting = "Hi " + request.getName() + ", you are " + request.getAge() + " years old," +
                " your hobbies are " + request.getHobbiesList() + ", your tags " + request.getTagsMap();

        HelloResponse response = HelloResponse.newBuilder().setGreeting(greeting).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
