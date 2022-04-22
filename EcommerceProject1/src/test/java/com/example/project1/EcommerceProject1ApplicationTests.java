package com.example.project1;

import com.example.project1.entities.Address;
import com.example.project1.entities.Customer;
import com.example.project1.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EcommerceProject1ApplicationTests {

	@Autowired
	CustomerRepository repository;

	@Test
	void contextLoads() {
	}
	@Test
	public void testCreateCustomer()
	{
		Customer customer=new Customer();
		customer.setContact(975832727L);
		customer.setFirstName("khushboo");
		repository.save(customer);
	}

}
