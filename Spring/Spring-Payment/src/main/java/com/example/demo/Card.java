package com.example.demo;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
@Component
@Scope("singleton")
@Primary
public class Card implements Payment {
    public Card() {
        System.out.println("CreditCardPayment Bean Created");
    }
    @PostConstruct
    public void init() {
        System.out.println("CreditCardPayment Bean Initialized");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("CreditCardPayment Bean Destroyed");
    }
    @Override
    public void pay(double amount) {
        System.out.println("Credit Card payment of Rs. " + amount + " successful");
    }
}