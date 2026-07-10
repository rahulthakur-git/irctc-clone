package com.rahul.irctc.repository;

import com.rahul.irctc.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking,Long> {

    Optional<Booking> findByPnr(String pnr);
}
