package com.avs.services;

import org.springframework.stereotype.Service;

@Service
public class WelcomeServiceImpl implements WelcomeService {

    public String retrieveWelcomeMessage() {
        //Complex Method
        return "Good Morning updated";
    }
}
