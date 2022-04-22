package com.example.project1.Services;

import com.example.project1.dtos.UserDto;
import com.example.project1.entities.User;
import com.example.project1.enums.ERole;
import com.example.project1.repositories.CustomerRepository;
import com.example.project1.repositories.RoleRepository;
import com.example.project1.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;


    @Autowired
    AdminService adminService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmailService emailService;

    public List<Object[]> getCustomerList() {
        List<Object[]> partialData = customerRepository.findAllCustomer();
        for (Object[] objects : partialData) {
            System.out.println("Id: " + objects[0] + " FullName: " + objects[1] + "Email: " + objects[2]);
        }
        return partialData;


    }

    public User activateCustomer(User user) {
        user.setActive(true);
        userRepository.save(user);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Account Activation!");
        mailMessage.setText("Congratulations!!\nYour account is being activated. We hope you enjoy our service");
        emailService.sendEmail(mailMessage);
        return user;

    }

    public User deactivateCustomer(User user) {
        user.setActive(false);
        userRepository.save(user);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setSubject("Account De-Activation!");
        mailMessage.setText("Your account is De-Activated :( \nFeel free to connect if you want to activate you account.");
        emailService.sendEmail(mailMessage);
        return user;

    }

    public void saveAdmin(UserDto admin) {
        User userRequest = modelMapper.map(admin, User.class);
        userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        userRequest.addRole(roleRepository.findByAuthority(ERole.ROLE_ADMIN.toString()));


        userRepository.save(userRequest);

    }

    public User activateSeller(User seller) {
        seller.setActive(true);
        userRepository.save(seller);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(seller.getEmail());
        mailMessage.setSubject("Account Activation!");
        mailMessage.setText("Congratulations!!\nYour account is being activated. We hope you enjoy our service");
        emailService.sendEmail(mailMessage);
        return seller;
    }

    public User deactivateSeller(User seller) {

        seller.setActive(false);
        userRepository.save(seller);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(seller.getEmail());
        mailMessage.setSubject("Account De-Activation!");
        mailMessage.setText("Your account is De-Activated :( \nFeel free to connect if you want to activate you account.");
        emailService.sendEmail(mailMessage);
        return seller;
    }
}

