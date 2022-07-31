package com.example.springbootmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.springbootmvc.service.IUserService;

@Controller
public class UserManagementController {

    private final IUserService userService;

    public UserManagementController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ModelAndView browseUsers() {

        var modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("users", userService.getUsers());
        modelAndView.addObject("pageTitle", "user-management");

        return modelAndView;
    }
}
