package com.example.usage;

import com.example.bean.Organization;
import com.example.config.AppConfigA;
import com.example.config.AppConfigB;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanOverloadingUsage {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigB.class, AppConfigA.class);

        System.out.println(context.getBean(Organization.class));
    }
}
