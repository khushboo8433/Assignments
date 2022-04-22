package com.example.project1.repositories;
import com.example.project1.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query("select id,concat(firstName,' ',COALESCE(middleName,''),' ',lastName) as FullName,email,isActive from Customer")// where isActive=true")
    List<Object[]> findAllCustomer();
    List<Customer> findAll();



    Customer findById(Customer customer);

    Customer findCustomerById(int id);

    @Query("select u.id, concat(u.firstName,' ', u.lastName) , u.email, u.isActive from User u join Customer c on c.id = u.id")
    List<Object[]> findAllCustomer(Pageable pageable);

    @Query("select u.id, u.firstName, u.lastName, u.isActive, c.contact from User u join Customer c on c.id=u.id")
    List<Object []> findDataById(@Param("s") String s);

    @Query("select a.id,a.city, a.country, a.addressLine, a.zipCode, a.label from Address a join Customer c on c.id=a.user.id where c.email=:s")
    List<Object []> findAddress(@Param("s") String s);

}
