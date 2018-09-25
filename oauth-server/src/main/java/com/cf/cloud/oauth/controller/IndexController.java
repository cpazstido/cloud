package com.cf.cloud.oauth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("index")
    @PreAuthorize("hasAuthority(user)")
    public String index(){
        return "this is oauth-server";
    }
}
