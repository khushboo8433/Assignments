package com.example.demo;

import com.example.demo.Component.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);
		ApplicationContext applicationContext=SpringApplication.run(DemoApplication.class);
		Car car=applicationContext.getBean(Car.class);
		car.printHonk();
		car.setProperties("56Q",1234);
	}
}
