package com.springapps.booking.D_model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate checkIn;

    @Column
    private LocalDate checkOut;

    @OneToMany(mappedBy = "reservation",  cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @JsonManagedReference("reservation-roomreservation")
    private List<RoomReservation> roomReservationList;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference("user-reservation")
    private User user;

    public Reservation() {
    }

    public Reservation(LocalDate checkIn, LocalDate checkOut, User user) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.user = user;
        roomReservationList = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public List<RoomReservation> getRoomReservationsList() {
        if(roomReservationList==null){
            roomReservationList = new ArrayList<>();
        }
        return roomReservationList;
    }

    public void setRoomReservationsList(List<RoomReservation> roomReservationList) {
        this.roomReservationList = roomReservationList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
