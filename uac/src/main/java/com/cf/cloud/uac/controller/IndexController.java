package com.cf.cloud.uac.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/index")
    public String index(String msg){
        return "user controller:"+msg;
    }
}
