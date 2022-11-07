package com.example.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.domain.model.response.ErrorMessageResponseModel;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(value = { UserNotFoundException.class })
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException exception,
            WebRequest webRequest) {

        return new ResponseEntity<>(new ErrorMessageResponseModel(ZonedDateTime.now(),
                exception.getMessage(), exception.getStackTrace()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
