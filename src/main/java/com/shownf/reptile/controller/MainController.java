package com.shownf.reptile.controller;

import com.shownf.reptile.Model.entity.TestDAO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class MainController {
    @GetMapping("/")
    public String health(){
        return "server on";
    }

    @GetMapping("/test")
    public List<TestDAO> healthtest(){
        List<TestDAO> testDAOS = new ArrayList<>();
        TestDAO testDAO1 = new TestDAO("nameIsTest1", "test data for front-back connection", 1);
        TestDAO testDAO2 = new TestDAO("nameIsTest2", "test data for front-back connection", 2);

        testDAOS.add(testDAO1);
        testDAOS.add(testDAO2);

        return testDAOS;
    }
}
