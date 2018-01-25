package com.avs.controllers;

import com.avs.services.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Autowired
    private WelcomeService service;

    @GetMapping("/welcome")
    public String welcome() {
        return service.retrieveWelcomeMessage();
    }
}

