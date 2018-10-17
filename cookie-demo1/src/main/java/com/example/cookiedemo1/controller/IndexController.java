package com.example.cookiedemo1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class IndexController {

    @RequestMapping("/index")
    public String index(HttpServletRequest request){

        String url = request.getRequestURL().toString();
        System.out.println("URL:"+url);
        if(request.getCookies()!=null){
            for(Cookie cookie:request.getCookies()){
                System.out.println("cookie:"+cookie.getName()+" value:"+cookie.getValue());
            }
        }
        return url;
    }

    @RequestMapping("/setCookie")
    public String setCookie(HttpServletRequest request,HttpServletResponse response){
        Cookie cookie = new Cookie("coo",request.getServerPort()+"");
        response.addCookie(cookie);
        return "set cookie success!";
    }

    @RequestMapping("/clearCookie")
    public String clearCookie(HttpServletResponse response){
        Cookie cookie = new Cookie("coo","mana");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "clear cookie success!";
    }
}
