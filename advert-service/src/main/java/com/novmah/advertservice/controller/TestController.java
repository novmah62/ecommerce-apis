package com.novmah.advertservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/api")
public class TestController {

    @Value("${spring.boot.message}")
    private String test;

    @GetMapping("/test")
    public String Test() {
        return this.test;
    }

}
