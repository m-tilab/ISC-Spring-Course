package com.example.springbootmvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springbootmvc.domain.User;
import com.example.springbootmvc.repository.UserRepository;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {

        return userRepository.getUsers();
    }
}
