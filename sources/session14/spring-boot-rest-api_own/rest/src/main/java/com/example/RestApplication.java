package com.example;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@SpringBootApplication
public class RestApplication implements ApplicationContextAware {

    private static ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

    public static Object getBean(String beanName) {

        return context.getBean(beanName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        context = applicationContext;
    }
}
