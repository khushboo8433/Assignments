package com.example.project1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;
@SpringBootApplication
public class EcommerceProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceProject1Application.class, args);

	}

		@Bean
		public ModelMapper modelMapper(){
			return new ModelMapper();
	}

}
