package com.august.service.impl;

import org.springframework.stereotype.Service;

import com.august.service.GreetingService;

@Service("greetingService")
public class GreetingServiceImpl implements GreetingService {
	
    @Override
    public String greet(String who) {
        return String.format("hello, %s!", who);
    }
}
