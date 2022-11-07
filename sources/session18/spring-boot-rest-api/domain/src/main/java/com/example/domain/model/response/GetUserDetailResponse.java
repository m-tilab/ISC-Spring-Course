package com.example.domain.model.response;

import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import com.example.domain.model.dto.RoleDTO;

import lombok.Data;

@Data
public class GetUserDetailResponse extends RepresentationModel<GetUserDetailResponse> {

    private String userId;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String encryptedPassword;

    private List<RoleDTO> roles;
}
