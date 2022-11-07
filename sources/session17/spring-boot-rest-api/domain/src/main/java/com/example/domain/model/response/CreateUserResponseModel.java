package com.example.domain.model.response;

import java.util.List;

import com.example.domain.model.dto.RoleDTO;

import lombok.Data;

@Data
public class CreateUserResponseModel {
    private String userId;
    private String firstname;
    private String lastname;
    private String username;
    private String email;

    private List<RoleDTO> roles;
}
