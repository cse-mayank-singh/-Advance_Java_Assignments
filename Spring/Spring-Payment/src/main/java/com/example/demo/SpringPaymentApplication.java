package com.example.demo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
@SpringBootApplication
public class SpringPaymentApplication {
    public static void main(String[] args) {
        // Directly scan the package
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.example.demo");
        // Default bean (because of @Primary)
        Payment payment = context.getBean(Payment.class);
        payment.pay(5000);
        System.out.println();
        // Prototype scope check
        UPI upi1 = context.getBean(UPI.class);
        UPI upi2 = context.getBean(UPI.class);
        System.out.println("Are UPI beans same? " + (upi1 == upi2));
        context.close();
    }
}