package com.example.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HelloWorldController {

    @ResponseBody
    @GetMapping("/hello-world")
    public String helloWorld() {

        log.info("Hello World Called");

        return "Hello Spring Boot";
    }

}
