package com.example.config;

import com.example.bean.Organization;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigB {

    @Bean
    public Organization getOrganization() {

        Organization organization = new Organization();
        organization.setTitle("Microsoft");
        organization.setNumberOfEmployee(30000);

        return organization;
    }
}
