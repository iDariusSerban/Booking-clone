package com.springapps.booking.C_repository;

import com.springapps.booking.D_model.Role;
import com.springapps.booking.D_model.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
   Optional<Role> findByRoleType(RoleType roleType);
}
