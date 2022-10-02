package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dao.repository.RoleRepository;
import com.example.dao.repository.UserRepository;
import com.example.domain.model.dto.UserDTO;
import com.example.domain.model.entity.RoleEntity;
import com.example.domain.model.entity.UserEntity;
import com.example.exception.UserNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDTO createCustomerUser(UserDTO userDTO) {

        if (userRepository.findByUsernameOrEmail(userDTO.getUsername(), userDTO.getEmail()).isPresent())
            throw new RuntimeException("duplicate username or email address");

        ModelMapper modelMapper = new ModelMapper();

        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);

        final Optional<RoleEntity> optionalCustomerRole = roleRepository.findByName("customer");

        if (optionalCustomerRole.isPresent())
            userEntity.setRoles(Set.of(optionalCustomerRole.get()));

        userEntity.setUserId(UUID.randomUUID().toString());

        userEntity.setEncryptedPassword(passwordEncoder.encode(userDTO.getPassword()));

        userEntity = userRepository.save(userEntity);

        userDTO = modelMapper.map(userEntity, UserDTO.class);

        return userDTO;

    }

    @Override
    public UserDTO createAdminUser(UserDTO userDTO) {

        if (userRepository.findByUsernameOrEmail(userDTO.getUsername(), userDTO.getEmail()).isPresent())
            throw new RuntimeException("duplicate username or email address");

        ModelMapper modelMapper = new ModelMapper();

        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);

        final Optional<RoleEntity> optionalAdminRole = roleRepository.findByName("admin");

        if (optionalAdminRole.isPresent())
            userEntity.setRoles(Set.of(optionalAdminRole.get()));

        userEntity.setUserId(UUID.randomUUID().toString());

        userEntity.setEncryptedPassword(passwordEncoder.encode(userDTO.getPassword()));

        userEntity = userRepository.save(userEntity);

        userDTO = modelMapper.map(userEntity, UserDTO.class);

        return userDTO;

    }

    @Override
    public UserDTO getByUsername(String username) {

        UserDTO userDTO = new UserDTO();

        Optional<UserEntity> userEntity = userRepository.findByUsername(username);

        if (userEntity.isEmpty())
            throw new UsernameNotFoundException(username);

        BeanUtils.copyProperties(userEntity.get(), userDTO);

        return userDTO;

    }

    @Override
    public UserDTO getByUserId(String userId) {

        UserDTO userDTO = new UserDTO();

        final Optional<UserEntity> optionalUserEntity = userRepository.findByUserId(userId);

        if (optionalUserEntity.isEmpty())
            throw new RuntimeException("UserId " + userId + " not found");

        BeanUtils.copyProperties(optionalUserEntity.get(), userDTO);

        return userDTO;

    }

    @Override
    public void updateUser(UserDTO userDTO) {

        final Optional<UserEntity> optionalUserEntity = userRepository.findByUserId(userDTO.getUserId());

        if (optionalUserEntity.isEmpty())
            throw new UserNotFoundException("UserId " + userDTO.getUserId() + " not found");

        final Optional<UserEntity> optionalExistUserEntity = userRepository.findByEmail(userDTO.getEmail());

        if (optionalExistUserEntity.isPresent() && !optionalExistUserEntity.get().getUserId().equals(userDTO.getUserId()))
            throw new RuntimeException("Duplicate Email address");

        UserEntity userEntity = optionalUserEntity.get();

        userEntity.setEmail(userDTO.getEmail());
        userEntity.setFirstname(userDTO.getFirstname());
        userEntity.setLastname(userDTO.getLastname());
        userEntity.setEncryptedPassword(passwordEncoder.encode(userDTO.getPassword()));

        userRepository.save(userEntity);
    }

    @Override
    public void deleteUserByUserId(String userId) {

        final Optional<UserEntity> optionalUserEntity = userRepository.findByUserId(userId);

        if (optionalUserEntity.isEmpty())
            throw new RuntimeException("UserId " + userId + " not found");

        userRepository.delete(optionalUserEntity.get());
    }

    @Override
    public Page<UserDTO> getUsers(PageRequest pageRequest) {
        var userDTOs = new ArrayList<UserDTO>();

        final Page<UserEntity> userEntities = userRepository.findAll(pageRequest);

        userEntities.forEach(userEntity -> {

            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(userEntity, userDTO);

            userDTOs.add(userDTO);
        });

        return new PageImpl<>(userDTOs, pageRequest, userEntities.getTotalElements());
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        final Optional<UserEntity> optionalUserEntity = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);

        if (optionalUserEntity.isPresent()) {

            final UserEntity userEntity = optionalUserEntity.get();

            final List<SimpleGrantedAuthority> authorities = userEntity.getRoles().stream()
                    .map(roleEntity -> new SimpleGrantedAuthority(roleEntity.getName()))
                    .collect(Collectors.toList());

            return new User(userEntity.getUsername(), userEntity.getEncryptedPassword(), authorities);
        }

        throw new UsernameNotFoundException(usernameOrEmail);
    }
}
