package com;

import com.example.config.AppConfig;
import com.exmaple.beans.DrawShape;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class usage {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        final DrawShape drawShape = (DrawShape) context.getBean("drawShape");

        drawShape.draw();

    }
}
