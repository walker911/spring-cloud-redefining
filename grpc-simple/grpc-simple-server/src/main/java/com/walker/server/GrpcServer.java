package com.walker.server;

import com.walker.server.service.HiService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * @author walker
 * @date 2019/1/4
 */
public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8082)
                .addService(new HiService())
                .build();
        System.out.println("starting server...");
        server.start();
        System.out.println("server started!");
        server.awaitTermination();
    }
}
