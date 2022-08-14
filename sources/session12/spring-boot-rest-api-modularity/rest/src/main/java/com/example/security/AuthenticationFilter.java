package com.example.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.example.RestApplication;

import io.jsonwebtoken.Jwts;

public class AuthenticationFilter extends BasicAuthenticationFilter {

    private SecurityConstants securityConstants;

    public AuthenticationFilter(AuthenticationManager authenticationManager) {

        super(authenticationManager);

        securityConstants = (SecurityConstants) RestApplication.getBean("securityConstants");

    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String headerToken = request.getHeader(securityConstants.getHeaderName());

        if (headerToken == null || !headerToken.startsWith(securityConstants.getTokenPrefix())) {

            chain.doFilter(request, response);

            return;
        }

        final UsernamePasswordAuthenticationToken authenticationToken = getAuthenticationToken(headerToken);

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthenticationToken(String token) {

        if (token != null) {

            token = token.replace(securityConstants.getTokenPrefix(), "");

            final String username = Jwts.parser()
                    .setSigningKey(securityConstants.getTokenSecret())
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();

            if (username != null)
                return new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());

            return null;

        }

        return null;

    }
}
