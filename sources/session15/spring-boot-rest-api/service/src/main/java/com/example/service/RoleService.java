package com.example.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.dao.repository.RoleRepository;
import com.example.domain.model.dto.RoleDTO;
import com.example.domain.model.entity.RoleEntity;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoleService implements IRoleService {


    private RoleRepository roleRepository;

    @Override
    public RoleDTO createRole(RoleDTO roleDTO) {

        RoleEntity roleEntity = new RoleEntity();
        BeanUtils.copyProperties(roleDTO, roleEntity);

        roleEntity = roleRepository.save(roleEntity);

        BeanUtils.copyProperties(roleEntity, roleDTO);

        return roleDTO;
    }
}
