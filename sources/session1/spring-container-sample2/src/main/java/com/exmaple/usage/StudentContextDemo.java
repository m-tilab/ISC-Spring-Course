package com.exmaple.usage;

import com.exmaple.otherbeans.Student;
import com.exmaple.config.AppConfig;
import com.exmaple.otherbeans.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudentContextDemo {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        final Student student = (Student) context.getBean("anotherStudent");
        final Teacher otherTeacher = (Teacher) context.getBean("otherTeacher");

        System.out.println(student);
        System.out.println(otherTeacher);
    }
}
