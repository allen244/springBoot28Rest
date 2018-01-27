package com.avs.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WelcomeServiceImpl implements WelcomeService {

    @Value("${welcome.message}")
    private String welcome;
    public String retrieveWelcomeMessage() {
        //Complex Method
        return welcome;
    }
}
