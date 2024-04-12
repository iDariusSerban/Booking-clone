package com.springapps.booking.A_controller;

import com.springapps.booking.B_service.HotelService;
import com.springapps.booking.D_model.Hotel;
import com.springapps.booking.E_dto.RoomRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    HotelService hotelService;
    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/{name}")
    public ResponseEntity<Hotel>addHotel(@PathVariable String name){
        return ResponseEntity.ok(hotelService.createHotel(name));
    }

    @PostMapping("/{hotelId}")
    public ResponseEntity<?> addRoomToHotel(@RequestBody RoomRequestDTO roomRequestDTO, @PathVariable Long hotelId){
        return ResponseEntity.ok(hotelService.addRoomToHotel(roomRequestDTO,hotelId));
    }
}
