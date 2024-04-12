package com.springapps.booking.A_controller;

import com.springapps.booking.B_service.UserService;
import com.springapps.booking.D_model.RoleType;
import com.springapps.booking.D_model.User;
import com.springapps.booking.E_dto.RoomRequestDTO;
import com.springapps.booking.E_dto.UserRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody UserRequestDTO userRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addNewUser(userRequestDTO));
    }

    @PostMapping("/{roleType}/user/{userId}")
    public ResponseEntity<?> addRoleToUser (@PathVariable RoleType roleType,@PathVariable Long userId){
        return ResponseEntity.ok(userService.addRoleToUser(roleType,userId));
    }






}
