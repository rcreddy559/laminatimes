package com.lamina.user.service;


import com.lamina.user.controller.UserResponse;

public class MultiMethods {

    public void user(UserResponse foo) {
        System.out.println("Received: " + foo);
    }

    public void unknown(Object object) {
        System.out.println("Received unknown: " + object);
    }

}
