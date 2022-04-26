package com.example.controller;

import com.example.service.RandomizerRequestScope;
import com.example.service.RandomizerSessionScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("")
public class RandomController {

    @Autowired
    private RandomizerRequestScope randomizerRequestScope;

    @Autowired
    private RandomizerSessionScope randomizerSessionScope;

    @RequestMapping("/")
    public void getRandom(HttpServletResponse httpServletResponse) throws IOException {

        httpServletResponse.getWriter().write("<!DOCTYPE html>");
        httpServletResponse.getWriter().write("old request scope:" + randomizerRequestScope.getRandomNumber() + "<br>");
        httpServletResponse.getWriter().write("new request scope:" + randomizerRequestScope.generateRandomNumber() + "<br>");

        httpServletResponse.getWriter().write("request scope:" + randomizerRequestScope + "<br>");

        httpServletResponse.getWriter().write("old session scope:" + randomizerSessionScope.getRandomNumber() + "<br>");
        httpServletResponse.getWriter().write("new session scope:" + randomizerSessionScope.generateRandomNumber() + "<br>");

        httpServletResponse.getWriter().write("session scope:" + randomizerSessionScope + "<br>");

    }

}
