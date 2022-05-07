package com.example.config;

import com.example.bean.Organization;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigA {

    @Bean
    public Organization getOrganization() {

        Organization organization = new Organization();
        organization.setTitle("MSI");
        organization.setNumberOfEmployee(15000);

        return organization;
    }
}
