package com.example.demo.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

    @Component
    public class Car{
    private Honk honk;
    private String model;
    private int number;

        public void setProperties(String model,int number) {
            this.model = model;
            this.number=number;
            System.out.println("Model of car is "+model);
            System.out.println("number of car is "+number);
        }
    @Autowired
    public Car(Honk honk) {
        this.honk=honk;
    }
    public void printHonk(){
        String s = honk.Honking();
        System.out.println(s);
        System.out.println(honk);
    }
}

