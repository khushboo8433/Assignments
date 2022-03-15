package com.example.demo.Component;

import org.springframework.stereotype.Component;

@Component
public class Audi implements Honk{
    public String Honking(){
        return "Audi Honking";
    }
}
