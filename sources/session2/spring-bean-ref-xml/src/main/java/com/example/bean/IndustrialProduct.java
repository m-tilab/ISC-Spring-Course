package com.example.bean;

import java.util.Random;

public class IndustrialProduct implements GenericProduct{
    @Override
    public int getQualifiedPrice() {

        return new Random().nextInt(price);
    }
}
