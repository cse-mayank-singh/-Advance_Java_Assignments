package com.example.demo;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
//@Scope("prototype")
public class Bike implements Vehicle{
	Bike(){
		System.out.println("Bike object created");
	}
	@Override
	public void run() {
		System.out.println("Bike running...");
	}
}