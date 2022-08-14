package com.example.dao.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.model.entity.UserEntity;

@Repository
public interface UserRepository extends
        CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsernameOrEmail(String username, String email);

    Optional<UserEntity> findByUsername(String username);
}
