package com.example;

import com.example.bean.TradeFair;
import com.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanQualifierUsage {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        final TradeFair tradeFair = context.getBean(TradeFair.class);

        System.out.println(tradeFair.getQualifiedProductPrice());


    }
}
