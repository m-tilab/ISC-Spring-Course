package com.example;

import com.example.bean.Member;
import com.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringBeanLifecycleAnnotation {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        final Member bean = context.getBean(Member.class);

        System.out.println(bean);

        context.close();
    }
}
