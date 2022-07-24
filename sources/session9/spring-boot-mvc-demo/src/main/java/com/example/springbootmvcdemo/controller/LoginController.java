package com.example.springbootmvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.springbootmvcdemo.domain.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

    @GetMapping("/login")
    public ModelAndView loginPage(ModelAndView modelAndView) {

        log.info("LoginPage called");

        User user = new User();
        user.setUsername("my username");
        user.setPassword("my pass");

        modelAndView.addObject("user", user);
        modelAndView.setViewName("login");

        return modelAndView;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {

        if (!user.getPassword().equals("123")) {

            model.addAttribute("error", "incorrect password");

        }

        return "login";
    }

}
