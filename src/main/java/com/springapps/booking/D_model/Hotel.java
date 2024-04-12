package com.springapps.booking.D_model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @OneToMany(mappedBy = "hotel",  cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JsonManagedReference("hotel-room")
    private List<Room> rooms;

    public Hotel() {
    }

    public Hotel(String name) {
        this.name = name;
        rooms= new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
