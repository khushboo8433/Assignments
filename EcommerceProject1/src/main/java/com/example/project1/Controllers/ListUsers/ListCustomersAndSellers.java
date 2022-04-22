package com.example.project1.Controllers.ListUsers;

import com.example.project1.Services.AdminService;
import com.example.project1.repositories.CustomerRepository;
import com.example.project1.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListCustomersAndSellers {

    @Autowired
    CustomerRepository userRepository;

    @Autowired
    SellerRepository sellerRepository;


    @Autowired
    AdminService adminService;

    @GetMapping("/viewCustomers")
    public List<Object[]> getCustomers(){
        System.out.println("Hello World");
        return userRepository.findAllCustomer();
    }
    @GetMapping("/viewSellers")
    public List<Object[]> getSellers(){
        System.out.println("Hello World");
        return sellerRepository.findAllSeller();
    }

//
//    @GetMapping("/viewCustomeers")
//    private String listProducts(Model model) {
//        model.addAttribute("customers",userRepository.findAll());
//        return "getCustomerList";
//    }

}