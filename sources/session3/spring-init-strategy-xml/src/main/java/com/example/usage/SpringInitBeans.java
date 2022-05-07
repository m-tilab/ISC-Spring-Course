package com.example.usage;

import com.example.bean.EagerBean;
import com.example.bean.LazyBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringInitBeans {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        System.out.println("All eager beans initialized");

        final LazyBean lazyBean = context.getBean(LazyBean.class);
        final EagerBean eagerBean = context.getBean(EagerBean.class);

        System.out.println("finish");
    }
}
