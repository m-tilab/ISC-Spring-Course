package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.model.dto.UserDTO;
import com.example.domain.model.request.CreateUserRequestModel;
import com.example.domain.model.response.CreateUserResponseModel;
import com.example.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<CreateUserResponseModel> createUser(@RequestBody CreateUserRequestModel createUserRequestModel) {

        CreateUserResponseModel responseModel = new CreateUserResponseModel();

        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(createUserRequestModel, userDTO);

        userDTO = userService.createUser(userDTO);

        //userDTO.setUserId("12345");

        BeanUtils.copyProperties(userDTO, responseModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseModel);
    }
}
