package com.example.springbootrestapi.model.request;

import javax.validation.constraints.Email;

import lombok.Data;

@Data
public class CreateUserRequestModel {

    private String firstname;
    private String lastname;
    private String username;
    private String password;

    @Email
    private String email;
}
