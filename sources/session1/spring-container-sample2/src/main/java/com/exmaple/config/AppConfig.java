package com.exmaple.config;

import com.exmaple.otherbeans.Student;
import com.exmaple.otherbeans.Teacher;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = {"com.exmaple.bean"})
//@ImportResource("spring.xml")
@Import({Student.class})
public class AppConfig {

    @Bean(name = "otherTeacher")
    Teacher getOtherTeacher() {
        return new Teacher();
    }
}
