package com.cf.cloud.order.web.client;

import com.cf.cloud.order.web.api.UserFeignApi;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

//@Component
public class UserFeignClient implements UserFeignApi{

    @Override
    public String index(String msg) {
        return "userFeignClient:"+msg;
    }
}
