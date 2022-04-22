package com.example.project1.repositories;

import com.example.project1.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);


    @Query(nativeQuery = true, value = "select is_active from User u where u.email=:s")
    Boolean findByActive(@Param("s") String s);
}
