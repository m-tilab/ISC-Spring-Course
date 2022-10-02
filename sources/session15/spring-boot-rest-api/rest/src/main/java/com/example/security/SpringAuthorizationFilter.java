package com.example.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.RestApplication;
import com.example.domain.model.dto.UserDTO;
import com.example.domain.model.request.UserLoginRequestModel;
import com.example.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SpringAuthorizationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;




    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {

            UserLoginRequestModel credential = new ObjectMapper().readValue(request.getInputStream(), UserLoginRequestModel.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    credential.getUsername(),
                    credential.getPassword(),
                    new ArrayList<>()
            ));

        } catch (IOException e) {

            throw new RuntimeException();
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {

        SecurityConstants securityConstants = (SecurityConstants) RestApplication.getBean("securityConstants");

        String username = ((User) authResult.getPrincipal()).getUsername();

        final String token = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + securityConstants.getExpirationPeriod()))
                .signWith(SignatureAlgorithm.HS512, securityConstants.getTokenSecret())
                .compact();

        response.addHeader(securityConstants.getHeaderName(), securityConstants.getTokenPrefix() + token);

        final IUserService userService = (IUserService) RestApplication.getBean("userService");

        final UserDTO userDTO = userService.getByUsername(username);

        response.addHeader("userId", userDTO.getUserId());

    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed)
            throws IOException, ServletException {

        throw new RuntimeException("invalid username or password");
    }
}
