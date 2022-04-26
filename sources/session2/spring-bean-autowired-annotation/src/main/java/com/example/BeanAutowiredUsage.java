package com.example;

import com.example.bean.TradeFair;
import com.example.config.AppConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanAutowiredUsage {

    public static void main(String[] args) {

        final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        TradeFair tradeFair = context.getBean(TradeFair.class);

        System.out.println(tradeFair.getQualifiedProductPrice());


    }
}
