package com.example.springbootmvc.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.springbootmvc.domain.User;

@Repository
public class UserRepository {

    public List<User> getUsers() {

        var user1 = new User("Ali", "Ahmadi", "ahmadi", "123456");
        var user2 = new User("Taghi", "Mousavi", "mousavi", "123456");
        var user3 = new User("Arezoo", "Sharifi", "sharifi", "123456");

        return List.of(user1, user2, user3);
    }

}
