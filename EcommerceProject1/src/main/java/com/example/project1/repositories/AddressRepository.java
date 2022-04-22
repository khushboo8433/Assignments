package com.example.project1.repositories;

import com.example.project1.entities.Address;
import com.example.project1.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    Address getByIdAndUser(int id, User user);
}
