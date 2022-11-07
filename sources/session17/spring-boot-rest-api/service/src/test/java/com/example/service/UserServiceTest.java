package com.example.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.dao.repository.UserRepository;
import com.example.domain.model.dto.UserDTO;
import com.example.domain.model.entity.UserEntity;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    private UserEntity userEntity;

    @BeforeEach
    void setUp() {

        //MockitoAnnotations.openMocks(this);

        userEntity = UserEntity.builder()
                .id(1L)
                .username("mahdi")
                .firstname("Mahdi")
                .lastname("Tilab")
                .build();
    }

    @Test
    void givenUser_whenGetByUsername_gettingObject() {

        when(userRepository.findByUsername(anyString())).thenReturn(Optional.of(userEntity));

        final UserDTO userDTO = userService.getByUsername("mahdi");

        assertEquals(userEntity.getUsername(), userDTO.getUsername());
        verify(userRepository, times(1)).findByUsername(anyString());
    }

    @Test
    void testGetInvalidUserProvided_ThrowUserNameNotFoundException() {

        when(userRepository.findByUsername(anyString())).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> {
            userService.getByUsername("Mahdi");
        });
    }

    @RepeatedTest(3)
    void repeatedTest(RepetitionInfo repetitionInfo) {

        System.out.println(repetitionInfo.getCurrentRepetition());

        assertEquals(Math.addExact(1,1), 2, "1 + 1 should be 2");
    }

    // timed out after 5 seconds
    @Test
    void test_timeout_fail() {
        //assertTimeout(Duration.ofSeconds(5), () -> delaySecond(6)); // this will fail

        assertTimeout(Duration.ofSeconds(5), () -> delaySecond(1)); // pass
    }

    void delaySecond(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }





}