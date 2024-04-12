package com.springapps.booking.B_service;

import com.springapps.booking.C_repository.RoomRepository;
import com.springapps.booking.D_model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {
    RoomRepository roomRepository;

    ReservationService reservationService;
    @Autowired
    public RoomService(RoomRepository roomRepository, ReservationService reservationService) {
        this.roomRepository = roomRepository;
        this.reservationService = reservationService;
    }

    public List<Room> getAvailableRoomsBy(LocalDate checkIn, LocalDate checkOut, Integer numberOfPersons){
        // de vizualizat a Booking java 8
        List<Room> foundRooms = roomRepository.findAllByGuestNumber(numberOfPersons);
        return foundRooms.stream()
                .filter(room -> isAvailable(room, checkIn, checkOut))
                .collect(Collectors.toList());
    }

    public boolean isAvailable(Room room, LocalDate checkIn , LocalDate checkOut){
        return room.getRoomReservationsList().stream()
                .map(roomReservation -> roomReservation.getReservation())
                .noneMatch(reservation -> reservationService.existReservationBetween(reservation,checkIn,checkOut));
    }

    public List<Room> getAvailableRoomsByPrice(LocalDate checkIn, LocalDate checkOut, Integer numberOfPersons){
       List<Room> availableRooms = getAvailableRoomsBy(checkIn, checkOut, numberOfPersons);
       return availableRooms.stream()
               .sorted((r1,r2) -> Double.compare(r1.getPricePerNight(), r2.getPricePerNight()))
               .collect(Collectors.toList());
    }
}
