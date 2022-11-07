package com.example.controller;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.model.dto.RoleDTO;
import com.example.domain.model.dto.UserDTO;
import com.example.domain.model.request.CreateUserRequestModel;
import com.example.domain.model.request.UserUpdateRequestModel;
import com.example.domain.model.response.CreateUserResponseModel;
import com.example.domain.model.response.GetUserDetailResponse;
import com.example.service.IRoleService;
import com.example.service.IUserService;

@RestController
@RequestMapping("/role")
public class RoleController {

    private IRoleService roleService;

    public RoleController(IRoleService roleService) {
        this.roleService = roleService;
    }



    @PostMapping
    public ResponseEntity<RoleDTO> createRole(@RequestBody RoleDTO roleDTO) {

        return ResponseEntity.status(HttpStatus.CREATED).body(roleService.createRole(roleDTO));
    }

}
