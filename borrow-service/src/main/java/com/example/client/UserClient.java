package com.example.client;

import com.example.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("user-service")  //声明为userservice服务的HTTP请求客户端
public interface UserClient {
    @RequestMapping("/user/{uid}")
    User findUserById(@PathVariable("uid")Integer uid);
}
