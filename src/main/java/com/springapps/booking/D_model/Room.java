package com.springapps.booking.D_model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long roomNumber;

    @Column
    private Double pricePerNight;

    @Column
    private Integer guestNumber;

    @OneToMany(mappedBy = "room",  cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @JsonManagedReference("roomreserv-room")
    List<RoomReservation> roomReservationList;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @JsonBackReference("hotel-room")
    private Hotel hotel;


    public Room() {
    }

    public Room(Long roomNumber, Double pricePerNight, Integer guestNumber, Hotel hotel) {
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.guestNumber = guestNumber;
        this.hotel = hotel;
        roomReservationList = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Long roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public Integer getGuestNumber() {
        return guestNumber;
    }

    public void setGuestNumber(Integer guestNumber) {
        this.guestNumber = guestNumber;
    }

    public List<RoomReservation> getRoomReservationsList() {
        return roomReservationList;
    }

    public void setRoomReservationsList(List<RoomReservation> roomReservationList) {
        this.roomReservationList = roomReservationList;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
