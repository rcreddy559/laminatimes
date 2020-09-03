package com.lamina.user.service;

import com.lamina.user.controller.User;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

public class MultiMethods {

    public void user(User foo) {
        System.out.println("Received: " + foo);
    }

    public void unknown(Object object) {
        System.out.println("Received unknown: " + object);
    }

}
