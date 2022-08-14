package com.example.service;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dao.repository.UserRepository;
import com.example.domain.model.dto.UserDTO;
import com.example.domain.model.entity.UserEntity;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements com.example.service.IUserService {

    private final UserRepository userRepository;

    @Lazy
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        if (userRepository.findByUsernameOrEmail(userDTO.getUsername(), userDTO.getEmail()).isPresent())
            throw new RuntimeException("duplicate username or email address");

        UserEntity userEntity = new UserEntity();

        BeanUtils.copyProperties(userDTO, userEntity);
        userEntity.setUserId(UUID.randomUUID().toString());

        userEntity.setEncryptedPassword(passwordEncoder.encode(userDTO.getPassword()));

        userEntity = userRepository.save(userEntity);

        BeanUtils.copyProperties(userEntity, userDTO);

        return userDTO;

    }
}
