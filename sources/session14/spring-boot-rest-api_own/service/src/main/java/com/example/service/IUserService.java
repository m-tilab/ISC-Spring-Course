package com.example.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.domain.model.dto.UserDTO;

public interface IUserService extends UserDetailsService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO getByUsername(String username);

    UserDTO getByUserId(String userId);

    void updateUser(UserDTO userDTO);

    void deleteUserByUserId(String userId);

    Page<UserDTO> getUsers(PageRequest pageRequest);
}
