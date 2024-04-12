package com.springapps.booking.C_repository;

import com.springapps.booking.D_model.Role;
import com.springapps.booking.D_model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {




}
