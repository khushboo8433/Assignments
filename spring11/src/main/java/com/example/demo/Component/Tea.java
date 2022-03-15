package com.example.demo.Component;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Tea implements HotDrink{
    public void prepareHotDrink() {
        System.out.println("this is tea");
    }
}
