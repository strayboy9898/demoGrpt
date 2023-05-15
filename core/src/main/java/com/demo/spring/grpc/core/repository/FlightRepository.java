package com.demo.spring.grpc.core.repository;

import com.demo.spring.grpc.core.model.Flight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {
    @Query("select flight from Flight flight where flight.id = ?1")
    Flight getById(Long id);
}
