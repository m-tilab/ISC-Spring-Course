package com.example.usage;

import com.example.bean.TradeFair;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanRefXMlUsage {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        final TradeFair tradeFair = context.getBean(TradeFair.class);

        System.out.println(tradeFair.getQualifiedProductPrice());
    }
}
