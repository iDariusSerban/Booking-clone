package com.springapps.booking.C_repository;

import com.springapps.booking.D_model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
   List<Room> findAllByGuestNumber(Integer numberOfPersons);

}
