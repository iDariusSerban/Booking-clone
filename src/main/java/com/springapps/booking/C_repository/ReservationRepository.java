package com.springapps.booking.C_repository;

import com.springapps.booking.D_model.Reservation;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findAllByCheckInAfterAndCheckOutBefore(LocalDate start, LocalDate end);
}
