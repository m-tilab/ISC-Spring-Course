package com.example.bean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Qualifier
public class ConsumerProduct implements GenericProduct{
    @Override
    public int getQualifiedPrice() {

        return new Random().nextInt(price);
    }
}
