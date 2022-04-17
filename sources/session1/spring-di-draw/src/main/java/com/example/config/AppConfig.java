package com.example.config;

import com.exmaple.beans.DrawShape;
import com.exmaple.beans.Rectangle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.exmaple.beans")
public class AppConfig {

    @Bean
    public DrawShape drawShape() {

        return new DrawShape(new Rectangle());
    }
}
