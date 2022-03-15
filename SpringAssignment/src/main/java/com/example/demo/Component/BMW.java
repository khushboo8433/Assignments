package com.example.demo.Component;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Component
@Primary
public class BMW implements Honk{

    public String Honking(){
        return "BMW Honking";
    }
}
