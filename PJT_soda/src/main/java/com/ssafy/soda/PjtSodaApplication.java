package com.ssafy.soda;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ssafy.soda")
@MapperScan("com.ssafy.soda.model.dao")
public class PjtSodaApplication {

	public static void main(String[] args) {
		ApplicationContext container = SpringApplication.run(PjtSodaApplication.class, args);
		for (String name : container.getBeanDefinitionNames())
			System.out.println(name);
	}

}
