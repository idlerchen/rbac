package com.xxy.rbac_cloud_upms_biz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/hello")
    public TestUser testUser(){
        return new TestUser();
    }
}
