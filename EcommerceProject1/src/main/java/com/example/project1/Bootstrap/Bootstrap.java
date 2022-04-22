package com.example.project1.Bootstrap;

import com.example.project1.Services.AdminService;
import com.example.project1.Services.RoleService;
import com.example.project1.Services.UserService;
import com.example.project1.dtos.UserDto;
import com.example.project1.entities.User;
import com.example.project1.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

import static com.example.project1.enums.ERole.*;


@Component
    public class Bootstrap implements ApplicationRunner {
        @Autowired
        private UserRepository userRepository;
        @Autowired
        private UserService userService;
        @Autowired
        private RoleService roleService;

        @Autowired
        AdminService adminService;

//    @Autowired
//    private SellerService sellerService;
//    @Autowired
//    private CustomerService customerService;


        @Override
        public void run(ApplicationArguments args) throws Exception {

            roleService.saveRole(ROLE_ADMIN);
            roleService.saveRole(ROLE_CUSTOMER);
            roleService.saveRole(ROLE_SELLER);

            String email="admin@gmail.com";
            User admin=userRepository.findByEmail(email);
            System.out.println(admin);
            if(admin==null)
            {
                adminService.saveAdmin(new UserDto(email, "Admin", "Admin", "Admin", "aDminn@123"));

            }
        }
    }
