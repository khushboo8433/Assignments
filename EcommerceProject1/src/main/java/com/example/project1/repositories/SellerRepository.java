package com.example.project1.repositories;

import com.example.project1.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SellerRepository extends JpaRepository<Seller,Integer> {

    //Seller findByEmail(String email);

@Query("select id,concat(firstName,' ',COALESCE(middleName,''),' ',lastName) as FullName,email,isActive from Seller")
List<Object[]> findAllSeller();
}
