package com.example.springbootrestapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootrestapi.model.entity.UserEntity;

@Repository
public interface UserRepository extends
        CrudRepository<UserEntity, Long> {

}
