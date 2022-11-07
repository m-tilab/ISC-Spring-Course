package com.example.domain.model.request;

import java.util.List;

import javax.validation.constraints.Email;

import com.example.domain.model.dto.RoleDTO;

import lombok.Data;

@Data
public class CreateUserRequestModel {

    private String firstname;
    private String lastname;
    private String username;
    private String password;

    @Email
    private String email;

    private List<RoleDTO> roles;
}
