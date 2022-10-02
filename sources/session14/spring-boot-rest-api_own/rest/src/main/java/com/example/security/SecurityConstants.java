package com.example.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class SecurityConstants {


    @Value("${sign-up-url}")
    private String signupUrl;

    @Value("${expiration-time}")
    private long expirationPeriod;

    @Value("${header-string}")
    private String headerName;

    @Value("${token-prefix}")
    private String tokenPrefix;

    @Value("${token-secret}")
    private String tokenSecret;

}
