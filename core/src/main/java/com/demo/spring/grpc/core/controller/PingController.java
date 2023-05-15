package com.demo.spring.grpc.core.controller;

import com.demo.spring.grpc.core.CoreApplication;
import com.demo.spring.grpc.core.schema.PingRequest;
import com.demo.spring.grpc.core.service.PingService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.function.FailableRunnable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/api")
@Slf4j
public class  PingController {
    @Autowired
    private PingService pingService;

    @GetMapping(path = "/ping", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> ping() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(safeRunnable(pingService::changeFlight1));
        executor.execute(safeRunnable(pingService::changeFlight2));
        executor.shutdown();
        return null;
    }

    private Runnable safeRunnable(FailableRunnable<Exception> runnable) {
        return () -> {
            try {
                runnable.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}
