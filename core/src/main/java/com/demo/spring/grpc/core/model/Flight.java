package com.demo.spring.grpc.core.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    private LocalDateTime departureTime;

    private Integer capacity;

    @Version
    private Long version;


    // ...
    // getters and setters
    // ...

//    public void addTicket(Ticket ticket) {
//        ticket.setFlight(this);
//        getTickets().add(ticket);
//    }

}
