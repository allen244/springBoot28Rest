package com.avs.controllers;

import com.avs.configurations.BasicConfiguration;
import com.avs.services.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WelcomeController {

    @Autowired
    private WelcomeService service;

    @GetMapping("/welcome")
    public String welcome() {
        return service.retrieveWelcomeMessage();
    }

    @Autowired
    private BasicConfiguration configuration;

    @RequestMapping("/dynamic-configuration")
    public Map dynamicConfiguration() {
        // Not the best practice to use a map to store differnt types!
        Map map = new HashMap();
        map.put("message", configuration.getMessage());
        map.put("number", configuration.getNumber());
        map.put("key", configuration.isValue());
        return map;
    }

}

