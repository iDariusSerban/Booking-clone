package com.springapps.booking.B_service;

import com.springapps.booking.C_repository.HotelRepository;
import com.springapps.booking.C_repository.RoomRepository;
import com.springapps.booking.D_model.Hotel;
import com.springapps.booking.D_model.Room;
import com.springapps.booking.E_dto.RoomRequestDTO;
import com.springapps.booking.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HotelService {
    private HotelRepository hotelRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Transactional
    public Hotel createHotel(String hotelName){
        Hotel hotel = new Hotel(hotelName);
        return hotelRepository.save(hotel);

    }

    @Transactional
    public Room addRoomToHotel(RoomRequestDTO roomRequestDTO, Long hotelId){
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("hotel does not exist!"));
        Room room = new Room(
                roomRequestDTO.getRoomNumber(),
                roomRequestDTO.getPricePerNight(),
                roomRequestDTO.getGuestNumber(),
                hotel
        );
        return roomRepository.save(room);
    }
}
