package com.example.demo;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
@Component("smsBean")
@Lazy              
public class SMSNotification implements Notification {
    public SMSNotification() {
        System.out.println("SmsNotification Bean Created");
    }
    @Override
    public void send(String message) {
        System.out.println("SMS Notification sent: " + message);
    }
}