package com.cf.cloud.order.web.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "UAC")
public interface UserFeignApi {

    @GetMapping("/index")
    public String index(@RequestParam("msg") String msg);
}
