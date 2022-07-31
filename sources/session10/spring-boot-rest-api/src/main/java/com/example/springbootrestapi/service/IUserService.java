package com.example.springbootrestapi.service;

import com.example.springbootrestapi.model.dto.UserDTO;

public interface IUserService {

    UserDTO createUser(UserDTO userDTO);
}
