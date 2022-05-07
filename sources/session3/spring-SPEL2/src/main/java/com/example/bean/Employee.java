package com.example.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {

    @Value("70")
    private int age;

    @Value("#{employee.getAge() * 12}")
    private int agePerMonth;

    private String firstname;
    private String lastname;

    @Value("#{employee.getAge() > 60}")
    private boolean retired;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAgePerMonth() {
        return agePerMonth;
    }

    public void setAgePerMonth(int agePerMonth) {
        this.agePerMonth = agePerMonth;
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

    public boolean isRetired() {
        return retired;
    }

    public void setRetired(boolean retired) {
        this.retired = retired;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", agePerMonth=" + agePerMonth +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", retired=" + retired +
                '}';
    }
}
