package com.demo.spring.grpc.core.service;

import com.demo.spring.grpc.core.exception.ExceededCapacityException;
import com.demo.spring.grpc.core.model.Customers;
import com.demo.spring.grpc.core.model.Flight;
import com.demo.spring.grpc.core.model.Ticket;
import com.demo.spring.grpc.core.repository.CustomersRepository;
import com.demo.spring.grpc.core.repository.FlightRepository;
import com.demo.spring.grpc.core.repository.TicketRepository;
import com.demo.spring.grpc.core.schema.*;
//import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Slf4j
public class PingService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    CustomersRepository customersRepository;

//    public PingResponse ping(PingRequest request) {
//        //log.info("Received Ping message {}", new Gson().toJson(request));
//        return PingResponse.newBuilder()
//            .setTimestamp(request.getTimestamp() * 2)
//            .setMessage("Pong from server ....")
//            .build();
//    }

//    public CustomerEntity findCustomer(CheckCustomerNumber customerNumber) {
//        //log.info("check live tracking id {}", new Gson().toJson(customerNumber));
//        Integer idTest = 103;
////        Customers customers = customersRepository.findByCustomerNumber(customerNumber.getCustomerNumber());
//        Customers customers = customersRepository.findByCustomerNumber(idTest);
//
//        return CustomerEntity.newBuilder()
//                .setCustomerNumber(customers.getCustomerNumber())
//                .setCustomerNumber(customers.getCustomerNumber())
//                .setContactLastName(customers.getContactLastName())
//                .setPhone(customers.getPhone())
//                .setAddressLine1(customers.getAddressLine1())
//                .setAddressLine2(customers.getAddressLine2())
//                .setCity(customers.getCity())
//                .setState(customers.getState())
//                .setPostalCode(customers.getPostalCode())
//                .build();
//    }

    private void saveNewTicket(String firstName, String lastName, Flight flight) throws Exception {
        if (flight.getCapacity() <= ticketRepository.findByFlight_id(flight.getId()).size()) {
            System.out.println("Het ve roi ....................");
            throw new ExceededCapacityException();
        }
        var ticket = new Ticket();
        ticket.setFirstName(firstName);
        ticket.setLastName(lastName);
        ticket.setFlight_id(flight.getId());
//        flight.addTicket(ticket);
        ticketRepository.save(ticket);
    }

    @Transactional
    public void changeFlight1() throws Exception {
        // the code of the first thread
        Flight flight = flightRepository.getById(1L);
        saveNewTicket("Robert", "Smith", flight);
        Thread.sleep(1_000);
    }

    @Transactional
    public void changeFlight2() throws Exception {
        // the code of the second thread
        Flight flight = flightRepository.getById(1L);
        saveNewTicket("Kate", "Brown", flight);
        Thread.sleep(1_000);
    }
}
