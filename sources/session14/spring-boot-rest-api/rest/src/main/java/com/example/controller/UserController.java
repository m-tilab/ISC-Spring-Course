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

import com.example.domain.model.dto.UserDTO;
import com.example.domain.model.request.CreateUserRequestModel;
import com.example.domain.model.request.UserUpdateRequestModel;
import com.example.domain.model.response.CreateUserResponseModel;
import com.example.domain.model.response.GetUserDetailResponse;
import com.example.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE })
    public GetUserDetailResponse getUser(@PathVariable String userId) {

        GetUserDetailResponse response = new GetUserDetailResponse();

        UserDTO userDTO = userService.getByUserId(userId);

        BeanUtils.copyProperties(userDTO, response);

        return response;
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

    @PutMapping
    public ResponseEntity<ResponseStatus> updateUser(@RequestBody UserUpdateRequestModel userUpdateRequestModel) {

        UserDTO userDTO = new UserDTO();

        BeanUtils.copyProperties(userUpdateRequestModel, userDTO);

        userService.updateUser(userDTO);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId) {

        userService.deleteUserByUserId(userId);
    }

    @GetMapping
    public Page<GetUserDetailResponse> getUsers(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit) {

        var userDetails = new ArrayList<GetUserDetailResponse>();

        final PageRequest pageRequest = PageRequest.of(page, limit);

        Page<UserDTO> userDTOS = userService.getUsers(pageRequest);

        userDTOS.forEach(userDTO -> {

            GetUserDetailResponse response = new GetUserDetailResponse();

            BeanUtils.copyProperties(userDTO, response);

            userDetails.add(response);
        });

        return new PageImpl<GetUserDetailResponse>(userDetails, pageRequest, userDTOS.getTotalElements());
    }
}
