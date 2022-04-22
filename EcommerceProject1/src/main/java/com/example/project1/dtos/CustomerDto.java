package com.example.project1.dtos;

import lombok.Data;

import javax.validation.constraints.Pattern;


@Data
    public class CustomerDto extends UserDto {

        private long contact;

        private String firstName;
        private String lastName;
        @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,15}$")
        private String password;
        private String confirmPassword;

    }


