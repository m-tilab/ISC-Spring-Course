package com.example.config;

import com.example.bean.EagerBean;
import com.example.bean.LazyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
//@Lazy all bean will be eager
@Configuration
@ComponentScan(basePackages = "com.example.bean")
public class AppConfig {

    @Bean
    public EagerBean getEager() {

        return new EagerBean();
    }

    @Lazy
    @Bean
    public LazyBean getLazy() {

        return new LazyBean();
    }
}
