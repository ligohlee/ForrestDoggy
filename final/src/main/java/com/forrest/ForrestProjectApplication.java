package com.forrest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan("com.forrest")
@MapperScan(basePackages= "")
public class ForrestProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(ForrestProjectApplication.class, args);
	}
}
