package com.example.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.domain.model.dto.UserDTO;

public interface IUserService extends UserDetailsService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO getByUsername(String username);
}
