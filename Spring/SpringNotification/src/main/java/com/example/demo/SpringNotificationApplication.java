package com.example.demo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class SpringNotificationApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("com.example.demo");
        System.out.println("Container started\n");
        Notification email = (Notification) context.getBean("emailBean");
        email.send("Welcome via Email!");
        System.out.println();
        Notification sms = (Notification) context.getBean("smsBean");
        sms.send("Welcome via SMS!");
        context.close();
    }
}