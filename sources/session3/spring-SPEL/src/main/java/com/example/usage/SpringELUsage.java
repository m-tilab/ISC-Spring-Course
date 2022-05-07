package com.example.usage;

import com.example.bean.Employee;
import com.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringELUsage {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        final Employee employee = context.getBean(Employee.class);

        System.out.println(employee);
    }
}
