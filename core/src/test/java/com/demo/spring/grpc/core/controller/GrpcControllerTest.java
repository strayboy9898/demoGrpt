package com.demo.spring.grpc.core.controller;

import com.demo.spring.grpc.core.model.CoreServiceGrpc;
import com.demo.spring.grpc.core.model.PingResponse;
import com.demo.spring.grpc.core.model.PingRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class GrpcControllerTest {
  @Test
  public void ping() {
    PingRequest request = PingRequest.newBuilder().setTimestamp(System.currentTimeMillis()).build();

    PingResponse response = smsServiceStub().ping(request);

    Assert.assertEquals(request.getTimestamp(), response.getTimestamp());
  }

  private CoreServiceGrpc.CoreServiceBlockingStub smsServiceStub() {
    ManagedChannel channel =
        ManagedChannelBuilder.forTarget("localhost:6790").usePlaintext().build();
    return CoreServiceGrpc.newBlockingStub(channel);
  }
}
