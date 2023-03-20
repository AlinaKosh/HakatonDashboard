package com.cbr.testTask.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @PostMapping("/test")
    public String test(){
        System.out.println("Got it!");
        return "cors test";

    }
}
