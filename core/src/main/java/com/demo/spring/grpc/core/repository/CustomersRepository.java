package com.demo.spring.grpc.core.repository;

import com.demo.spring.grpc.core.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer> {
    @Query("select cus from Customers cus where cus.customerNumber = ?1")
    Customers findByCustomerNumber(Integer customerNumber);

//    @Query("select cus from Customers cus where cus.customerName = ?1")
//    Customers findByCustomerName(String customerName);
}
