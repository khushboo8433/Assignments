package com.example.project1.repositories;

import com.example.project1.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    Role findByAuthority(String role_customer);
}
