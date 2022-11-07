package com.example.dao.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.model.entity.RoleEntity;
import com.example.domain.model.entity.UserEntity;

@Repository
public interface RoleRepository extends
        CrudRepository<RoleEntity, Long> {

    Optional<RoleEntity> findByName(String name);
}
