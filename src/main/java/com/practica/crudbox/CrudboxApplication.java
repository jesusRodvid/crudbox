package com.practica.crudbox;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudboxApplication {

	@Bean
	public ModelMapper modelMapper(){

		return new ModelMapper();

	}
	public static void main(String[] args) {
		SpringApplication.run(CrudboxApplication.class, args);
	}

}
