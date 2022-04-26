package com.example.bean;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Member {

    private String name;
    private String lastname;

    public String getName() {
        return name;
    }

    @Value("${firstname}")
    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    @Value("${lastname}")
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
