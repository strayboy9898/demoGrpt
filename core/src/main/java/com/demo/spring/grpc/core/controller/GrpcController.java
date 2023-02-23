package com.demo.spring.grpc.core.controller;

import com.demo.spring.grpc.core.schema.*;
import com.demo.spring.grpc.core.service.PingService;


import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;


@Slf4j
@GRpcService
public class GrpcController extends CoreServiceGrpc.CoreServiceImplBase {
    @Autowired
    private PingService pingService;

    @Override
    public void ping(PingRequest request, StreamObserver<PingResponse> responseObserver) {
        responseObserver.onNext(pingService.ping(request));
        responseObserver.onCompleted();
    }

    @Override
    public void checkDriver(CheckDriverId checkDriverId, StreamObserver<DriverEntity> responseObserver) {
        DriverEntity reply = DriverEntity.newBuilder()
                .setName("Hello again " )
                .build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void checkCustomer(CheckCustomerNumber customerNumber, StreamObserver<CustomerEntity> responseObserver) {
        responseObserver.onNext(pingService.findCustomer(customerNumber));
        responseObserver.onCompleted();
    }
}
