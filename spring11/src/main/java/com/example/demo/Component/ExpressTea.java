package com.example.demo.Component;

import org.springframework.stereotype.Component;

@Component
public class ExpressTea implements HotDrink {
    public void prepareHotDrink()
    {
        System.out.println("this is express tea");
    }
}
