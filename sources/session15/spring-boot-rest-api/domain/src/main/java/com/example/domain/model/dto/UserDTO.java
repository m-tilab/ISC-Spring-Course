package com.example.domain.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserDTO {

    private long id;
    private String userId;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
    private String encryptedPassword;

    private List<RoleDTO> roles;

}
