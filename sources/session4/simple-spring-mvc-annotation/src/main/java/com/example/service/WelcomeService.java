package com.example.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WelcomeService implements IWelcomeService {


    @Override
    public List<String> getWelcomeMessages(String name) {

        // JDK 1.2
        //List list1 = new ArrayList();

        // JDK 1.5
        //List<String> list2 = new ArrayList<String>();

        // JDK 7
        //List<String> list3 = new ArrayList<>();

        // JDK 10
        //var myList = new ArrayList<>();

        var myWelcomeMessage =
                List.of("Hello! ", name, ", Welcome to Spring Course");

        List<String> myList = new ArrayList<>();
        myList.add("hello");
        myList.add(name);
        myList.add("welcome");

        return myWelcomeMessage;
    }
}
