package com.example;

import com.example.bean.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class ContextUsage {

    public static void main(String[] args) {

        //ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        // final Student student = (Student) context.getBean("student");

        BeanFactory context = new XmlBeanFactory(new ClassPathResource("spring.xml"));
        final Student student = (Student) context.getBean("student");
        // Student student = new Student();

        student.setFirstname("mehdi");
        student.setLastname("tilab");

        System.out.println(student);



    }
}
