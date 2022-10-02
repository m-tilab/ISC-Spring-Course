package com.example.domain.model.response;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorMessageResponseModel {

    private ZonedDateTime errorDateTime;
    private String message;
    private StackTraceElement[] stacktrace;

}
