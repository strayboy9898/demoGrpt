package com.demo.spring.grpc.core.service;

import com.google.gson.Gson;
import com.demo.spring.grpc.core.model.PingRequest;
import com.demo.spring.grpc.core.model.PingResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class PingService {
    public PingResponse ping(PingRequest request) {
        log.info("Received Ping message {}", new Gson().toJson(request));
        return PingResponse.newBuilder()
            .setTimestamp(request.getTimestamp() * 2)
            .setMessage("Pong")
            .build();
    }
}
