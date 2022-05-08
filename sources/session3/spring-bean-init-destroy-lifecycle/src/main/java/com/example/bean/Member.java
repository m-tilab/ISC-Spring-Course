package com.example.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Member implements InitializingBean, DisposableBean {

    private String firstname;
    private String lastname;

    public Member() {

        System.out.println("constructor of Member called");
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Member{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @PostConstruct
    public void postConstruct() {

        System.out.println("postConstruct called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet called");
    }

    public void initMethod() {

        System.out.println("initMethod called");
    }

    @PreDestroy
    public void preDestroy() {

        System.out.println("PreDestroy called");
    }

    private void destroyMethod() {

        System.out.println("destroyMethod called");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean destroy called");
    }
}
