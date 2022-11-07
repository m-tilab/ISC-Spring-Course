package com.example.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.service.IUserService;

import lombok.AllArgsConstructor;

@EnableWebSecurity
@AllArgsConstructor
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private final IUserService userService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final SecurityConstants securityConstants;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests().antMatchers(HttpMethod.POST, securityConstants.getSignupUrl()).permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(getAuthorizationFilter())
                .addFilterBefore(new AuthenticationFilter(authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }

    public SpringAuthorizationFilter getAuthorizationFilter() throws Exception {

        SpringAuthorizationFilter authenticationFilter = new SpringAuthorizationFilter(authenticationManager());
        authenticationFilter.setFilterProcessesUrl("/user/login");

        return authenticationFilter;
    }
}
