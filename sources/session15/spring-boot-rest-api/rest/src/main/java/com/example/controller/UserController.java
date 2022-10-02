package com.example.controller;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.example.service.IRoleService;
import com.example.service.IUserService;
import com.example.service.RoleService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private IUserService userService;
    private IRoleService roleService;

    @GetMapping(value = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE })
    public GetUserDetailResponse getUser(@PathVariable String userId) {

        GetUserDetailResponse response = new GetUserDetailResponse();

        UserDTO userDTO = userService.getByUserId(userId);

        BeanUtils.copyProperties(userDTO, response);

        return response;
    }

    @PostMapping
    public ResponseEntity<CreateUserResponseModel> createCustomerUser(@RequestBody CreateUserRequestModel createUserRequestModel) {

        ModelMapper modelMapper = new ModelMapper();

        UserDTO userDTO = modelMapper.map(createUserRequestModel, UserDTO.class);

        userDTO = userService.createCustomerUser(userDTO);

        CreateUserResponseModel responseModel = modelMapper.map(userDTO, CreateUserResponseModel.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseModel);
    }

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("/admin")
    public ResponseEntity<CreateUserResponseModel> createAdminUser(@RequestBody CreateUserRequestModel createUserRequestModel) {

        ModelMapper modelMapper = new ModelMapper();

        UserDTO userDTO = modelMapper.map(createUserRequestModel, UserDTO.class);

        userDTO = userService.createAdminUser(userDTO);

        CreateUserResponseModel responseModel = modelMapper.map(userDTO, CreateUserResponseModel.class);

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
