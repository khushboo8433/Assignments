package com.example.demo;
import com.example.demo.Component.Restaurant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDemo {

	public static void main(String[] args) {
		ApplicationContext applicationContext=
				SpringApplication.run(SpringDemo.class, args);
		Restaurant restaurant;
		restaurant = applicationContext.getBean(Restaurant.class);
		restaurant.getHotDrink().prepareHotDrink();
	}

}
