package com.example.bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

public class LazyBean {

    public LazyBean() {

        System.out.println("LazyBean initialized");
    }
}
