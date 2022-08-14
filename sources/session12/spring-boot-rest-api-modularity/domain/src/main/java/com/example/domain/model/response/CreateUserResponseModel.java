package com.example.domain.model.response;

import lombok.Data;

@Data
public class CreateUserResponseModel {
    private String userId;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
}
