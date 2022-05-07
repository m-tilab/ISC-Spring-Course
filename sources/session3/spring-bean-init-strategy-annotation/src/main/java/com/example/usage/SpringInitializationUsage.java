package com.example.usage;

import com.example.bean.LazyBean;
import com.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringInitializationUsage {

    public static void main(String[] args) {

        ApplicationContext  context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("eager beans initialized");

        LazyBean lazyBean = context.getBean(LazyBean.class);


    }
}
