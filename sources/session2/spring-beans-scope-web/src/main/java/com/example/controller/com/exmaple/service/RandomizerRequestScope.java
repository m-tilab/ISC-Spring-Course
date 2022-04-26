package com.example.controller.com.exmaple.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomizerRequestScope {

    private int randomNumber = 5;

    public int getRandomNumber() {
        return randomNumber;
    }

    public int generateRandomNumber() {

        this.randomNumber = new Random().nextInt(100000);

        return this.randomNumber;
    }
}
