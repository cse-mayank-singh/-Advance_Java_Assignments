package com.example.demo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Component
@Primary
public class Car implements Vehicle{
	Car(){
		System.out.println("Car object created");
	}
	@Override
	public void run() {
		System.out.println("Car running...");
	}
}