package com.cf.cloud.order.web;

import com.cf.cloud.order.web.api.UserFeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private UserFeignApi userFeignApi;

    @GetMapping("index")
    public String index(String msg){
        return "order:"+userFeignApi.index(msg);
    }
}
