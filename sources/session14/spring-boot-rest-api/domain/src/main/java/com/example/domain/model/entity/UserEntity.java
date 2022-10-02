package com.example.domain.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 100)
    private String userId;

    @Column(nullable = false, length = 100)
    private String firstname;

    @Column(nullable = false, length = 100)
    private String lastname;

    @Column(unique = true)
    private String username;
    private String email;
    private String encryptedPassword;
}
