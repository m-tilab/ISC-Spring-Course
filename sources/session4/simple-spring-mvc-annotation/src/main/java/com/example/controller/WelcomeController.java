package com.example.controller;

import com.example.service.IWelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WelcomeController {

    @Autowired
    private IWelcomeService welcomeService;


    @RequestMapping("/")
    public String doWelcome(Model model) {

        final List<String> welcomeMessages = welcomeService.getWelcomeMessages("Ahmad");

        model.addAttribute("myWelcomeMessage", welcomeMessages);

        return "welcome";
    }
}
