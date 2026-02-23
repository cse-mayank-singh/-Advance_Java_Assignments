package com.example.demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
//		ApplicationContext context=SpringApplication.run(DemoApplication.class, args);
//		SpringApplication.run(DemoApplication.class, args);
//		System.out.println("Hello World");
//		Car car1=context.getBean(Car.class);
//		System.out.println(car1);
//		Vehicle vehicle=context.getBean("car");
//		vehicle.run();
		BeanFactory factory=SpringApplication.run(DemoApplication.class, args);
		Vehicle vehicle=factory.getBean(Car.class);
		vehicle.run();
	}
}
