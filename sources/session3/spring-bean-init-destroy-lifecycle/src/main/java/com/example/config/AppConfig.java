package com.example.config;

import com.example.bean.Member;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.bean")
public class AppConfig {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public Member getMember() {

        System.out.println("AppConfig Member Bean  called");

        return new Member();
    }
}
