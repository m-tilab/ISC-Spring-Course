package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/user")
public class WebUserController {


    @GetMapping
    public String getUsers() {

        return "users";
    }

}
