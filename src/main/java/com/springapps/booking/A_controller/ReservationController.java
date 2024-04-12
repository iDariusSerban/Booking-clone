package com.springapps.booking.A_controller;

import com.springapps.booking.B_service.ReservationService;
import com.springapps.booking.D_model.Reservation;
import com.springapps.booking.E_dto.ReservationRequestDTO;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;


    @PostMapping
    public ResponseEntity<Reservation> addReservation (@RequestBody ReservationRequestDTO reservationRequestDTO){
        return ResponseEntity.ok(reservationService.addReservation(reservationRequestDTO));
    }




}
