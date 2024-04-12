package com.springapps.booking.C_repository;

import com.springapps.booking.D_model.RoomReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomReservationsRepository extends JpaRepository<RoomReservation, Long> {
}
