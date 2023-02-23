package com.demo.spring.grpc.core.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@Data
public class Customers {

    @Id
    @Column(name = "customerNumber", unique = true, nullable = false)
    protected Integer customerNumber;

    @Column(name = "customerName")
    protected String customerName;

    @Column(name = "contactLastName")
    protected String contactLastName;

    @Column(name = "phone")
    protected String phone;

    @Column(name = "addressLine1")
    protected String addressLine1;

    @Column(name = "addressLine2")
    protected String addressLine2;

    @Column(name = "city")
    protected String city;

    @Column(name = "state")
    protected String state;

    @Column(name = "postalCode")
    protected String postalCode;

}