package com.shownf.reptile.controller;

import com.shownf.reptile.entity.TestDAO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class MainController {
    @GetMapping("/")
    public String health(){
        return "server on";
    }

    @GetMapping("/test")
    public TestDAO healthtest(){
        TestDAO testDAO = new TestDAO("nameIsTest", "test data for front-back connection", 12);
        return testDAO;
    }
}
