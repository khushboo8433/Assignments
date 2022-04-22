package com.example.project1.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto
{
        private String city;
        private String state;
        private String country;
        private String addressLine;
        private Integer zipCode;
        private String label;

}
