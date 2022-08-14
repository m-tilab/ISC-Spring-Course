package com.example.service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dao.repository.UserRepository;
import com.example.domain.model.dto.UserDTO;
import com.example.domain.model.entity.UserEntity;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;

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

    @Override
    public UserDTO getByUsername(String username) {

        UserDTO userDTO = new UserDTO();

        Optional<UserEntity> userEntity = userRepository.findByUsername(username);

        if (userEntity.isEmpty())
            throw new UsernameNotFoundException(username);

        BeanUtils.copyProperties(userEntity.get(), userDTO);

        return userDTO;


    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        final Optional<UserEntity> optionalUserEntity = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);

        if (optionalUserEntity.isPresent()) {

            final UserEntity userEntity = optionalUserEntity.get();

            return new User(userEntity.getUsername(), userEntity.getEncryptedPassword(), new ArrayList<>());
        }

        throw new UsernameNotFoundException(usernameOrEmail);
    }
}
