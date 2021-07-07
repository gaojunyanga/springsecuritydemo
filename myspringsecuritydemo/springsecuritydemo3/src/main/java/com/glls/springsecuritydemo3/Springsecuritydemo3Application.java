package com.glls.springsecuritydemo3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@MapperScan(basePackages = {"com.glls.springsecuritydemo3.mapper"})
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class Springsecuritydemo3Application {

	public static void main(String[] args) {
		SpringApplication.run(Springsecuritydemo3Application.class, args);
	}

}
