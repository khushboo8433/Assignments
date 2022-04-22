package com.example.project1.dtos;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
public class SellerDto extends UserDto{

    private String gst;
    private BigInteger companyContact;
    private String companyName;

//    public SellerDto(){
//        this.setDeleted(Boolean.FALSE);
//        this.setExpired(false);
//        this.setLocked(true);
//        this.setInvalidAttemptCount(0);
//        this.setPasswordUpdateDate(new Date());
//        this.setActive(true);
//        this.setDeleted(false);
//
//    }


}
