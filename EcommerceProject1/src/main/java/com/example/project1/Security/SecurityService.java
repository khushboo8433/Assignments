package com.example.project1.Security;

public interface SecurityService {

    boolean login(String userName,String password);


    boolean logout(String email, String password);
}

