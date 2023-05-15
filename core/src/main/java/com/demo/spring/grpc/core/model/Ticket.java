package com.demo.spring.grpc.core.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long flight_id;

    private String firstName;

    private String lastName;

    // ...
    // getters and setters
    // ...
}
