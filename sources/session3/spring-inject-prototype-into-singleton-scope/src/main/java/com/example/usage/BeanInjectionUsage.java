package com.example.usage;

import com.example.bean.SingletonBean;
import com.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanInjectionUsage {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        final SingletonBean singletonBean = context.getBean(SingletonBean.class);

        System.out.println(singletonBean.getPrototypeBean());

        final SingletonBean singleton2Bean = context.getBean(SingletonBean.class);

        System.out.println(singleton2Bean.getPrototypeBean());
    }
}
