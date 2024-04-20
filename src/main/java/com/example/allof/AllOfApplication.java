package com.example.allof;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.allof.Mapping")
public class AllOfApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllOfApplication.class, args);
	}

}
