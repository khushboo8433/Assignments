package com.example.project1.Services;

import com.example.project1.Exception.UserNotFoundException;
import com.example.project1.dtos.AddressDto;
import com.example.project1.dtos.CustomerDto;
import com.example.project1.entities.Address;
import com.example.project1.entities.Customer;
import com.example.project1.entities.User;
import com.example.project1.repositories.AddressRepository;
import com.example.project1.repositories.CustomerRepository;
import com.example.project1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    public class CustomerService {

        @Autowired
        private CustomerRepository customerRepository;

        @Autowired
        private UserRepository userRepository;


        @Autowired
        private PasswordEncoder passwordEncoder;

        @Autowired
        private AddressRepository addressRepository;

        Boolean customerExist(String email){
            return userRepository.findByEmail(email) !=null ? true : false;
        }

        public List<Object []> getMyData(String email){
            if (customerExist(email)){
                List<Object[]> partialData = customerRepository.findDataById(email);
                return partialData;
            }
            else {
                throw new UserNotFoundException("Customer not found");
            }
        }

        public List<Object []> getAddress(String email){
            if (customerExist(email)){
                List<Object[]> partialData = customerRepository.findAddress(email);
                return partialData;
            }
            else {
                throw new UserNotFoundException("Customer not found");
            }
        }


        public void updateProfile(String email, CustomerDto customerDto){
            if (customerExist(email)){
                User user=userRepository.findByEmail(email);
                user.setFirstName(customerDto.getFirstName());
                user.setLastName(customerDto.getLastName());
                int id = user.getId();
                Customer customer = customerRepository.findCustomerById(id);
                customer.setContact(customerDto.getContact());
                userRepository.save(user);
                customerRepository.save(customer);
            }
            else {
                throw new UserNotFoundException("Customer not found");
            }
        }

        public void updateMyPassword(String email, CustomerDto customerDto){
            if (customerExist(email)){
                User user=userRepository.findByEmail(email);
                user.setPassword(passwordEncoder.encode(customerDto.getPassword()));
                userRepository.save(user);
            }
            else {
                throw new UserNotFoundException("Customer not found");
            }
        }

        public void addAddress(String email, AddressDto addressDto){
            if (customerExist(email)){
                User user=userRepository.findByEmail(email);
                Address address = new Address();
                address.setCity(addressDto.getCity());
                //address.setState(addressDto.getState());
                address.setCountry(addressDto.getCountry());
                address.setAddressLine(addressDto.getAddressLine());
                address.setZipCode(addressDto.getZipCode());
                address.setLabel(addressDto.getLabel());
                address.setUser(user);
                addressRepository.save(address);
            }
            else {
                throw new UserNotFoundException("Customer not found");
            }
        }

        public void deleteAddress(String email, int id){
            if (customerExist(email)){
                User user=userRepository.findByEmail(email);
                addressRepository.delete(addressRepository.getByIdAndUser(id, user));
            }
            else {
                throw new UserNotFoundException("Address not found");
            }
        }

        public void updateAddress(String email, AddressDto addressDto, int id){
            if (customerExist(email)){
                User user=userRepository.findByEmail(email);
                Address address = addressRepository.getByIdAndUser(id, user);
                address.setCity(addressDto.getCity());
               // address.setState(addressDto.getState());
                address.setCountry(addressDto.getCountry());
                address.setAddressLine(addressDto.getAddressLine());
                address.setZipCode(addressDto.getZipCode());
                address.setLabel(addressDto.getLabel());
                addressRepository.save(address);
            }
            else {
                throw new UserNotFoundException("Address not found");
            }
        }
    }

