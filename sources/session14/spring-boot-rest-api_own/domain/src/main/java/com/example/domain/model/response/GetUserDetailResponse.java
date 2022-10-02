package com.example.domain.model.response;

import lombok.Data;

@Data
public class GetUserDetailResponse {

    private String userId;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String encryptedPassword;
}
