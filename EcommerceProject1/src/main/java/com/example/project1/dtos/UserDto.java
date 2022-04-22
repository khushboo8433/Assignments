package com.example.project1.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;


@Data
public class UserDto {
    private int id;
    private String email;
    private String firstName;
    private String middleName;
    private String lastName;
    @Size(min = 7,max = 15,message = "password should contain at least 1 uppercase,1 lowercase,1 special character,1 number")
    private String password;
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    private String confirmpassword;
    private boolean isDeleted;
    private boolean isActive;
    private boolean isExpired;
    private boolean isLocked;
    private int invalidAttemptCount;
    private Date passwordUpdateDate;




    public UserDto(){
        this.setDeleted(Boolean.FALSE);
        this.setExpired(false);
        this.setLocked(true);
        this.setInvalidAttemptCount(0);
        this.setPasswordUpdateDate(new Date());
        this.setActive(false);
        this.setDeleted(false);

    }

    public UserDto(String email, String firstName, String middleName, String lastName, String password) {
        this.email = email;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.password = password;
        this.setDeleted(Boolean.FALSE);
        this.setLocked(false);
        this.setInvalidAttemptCount(0);
        this.setPasswordUpdateDate(new Date());
        this.setActive(true);
        this.setDeleted(false);
    }
}

