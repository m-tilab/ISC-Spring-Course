package com.example.springbootrestapi.service;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.springbootrestapi.model.dto.UserDTO;
import com.example.springbootrestapi.model.entity.UserEntity;
import com.example.springbootrestapi.repository.UserRepository;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        UserEntity userEntity = new UserEntity();

        BeanUtils.copyProperties(userDTO, userEntity);
        userEntity.setUserId(UUID.randomUUID().toString());

        userEntity = userRepository.save(userEntity);

        BeanUtils.copyProperties(userEntity, userDTO);

        return userDTO;

    }
}
