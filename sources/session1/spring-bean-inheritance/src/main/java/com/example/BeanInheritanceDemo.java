package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanInheritanceDemo {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        final Parent parent = (Parent) context.getBean("parent");
        parent.setFirstname("taghi");
        final Child child = (Child) context.getBean("child");


        System.out.println(parent);
        System.out.println(child);
    }
}
