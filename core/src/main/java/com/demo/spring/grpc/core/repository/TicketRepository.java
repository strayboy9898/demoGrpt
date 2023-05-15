package com.demo.spring.grpc.core.repository;

import com.demo.spring.grpc.core.model.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {
    @Query(value = "select ticket from Ticket ticket where ticket.flight_id = ?1")
    List<Ticket> findByFlight_id(Long flightId);
}
