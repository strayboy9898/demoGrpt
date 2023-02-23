package com.demo.spring.grpc.core.service;

import com.demo.spring.grpc.core.model.Customers;
import com.demo.spring.grpc.core.repository.CustomersRepository;
import com.demo.spring.grpc.core.schema.*;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class PingService {
    @Autowired
    CustomersRepository customersRepository;

    public PingResponse ping(PingRequest request) {
        log.info("Received Ping message {}", new Gson().toJson(request));
        return PingResponse.newBuilder()
            .setTimestamp(request.getTimestamp() * 2)
            .setMessage("Pong from server ....")
            .build();
    }

    public CustomerEntity findCustomer(CheckCustomerNumber customerNumber) {
        log.info("check live tracking id {}", new Gson().toJson(customerNumber));
        Integer idTest = 103;
//        Customers customers = customersRepository.findByCustomerNumber(customerNumber.getCustomerNumber());
        Customers customers = customersRepository.findByCustomerNumber(idTest);

        return CustomerEntity.newBuilder()
                .setCustomerNumber(customers.getCustomerNumber())
                .setCustomerNumber(customers.getCustomerNumber())
                .setContactLastName(customers.getContactLastName())
                .setPhone(customers.getPhone())
                .setAddressLine1(customers.getAddressLine1())
                .setAddressLine2(customers.getAddressLine2())
                .setCity(customers.getCity())
                .setState(customers.getState())
                .setPostalCode(customers.getPostalCode())
                .build();
    }
}
