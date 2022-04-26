package com.example;

import com.example.bean.Member;
import com.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanUsage {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        final Member member1 = context.getBean(Member.class);

        System.out.println(member1.getMemberType());

        final Member member2 = context.getBean(Member.class);

        System.out.println(member2.getMemberType());
    }
}
