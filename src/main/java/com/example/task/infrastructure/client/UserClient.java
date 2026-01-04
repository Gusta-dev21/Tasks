package com.example.task.infrastructure.client;


import com.example.task.infrastructure.entity.dto.UserRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="user",url="localhost:8081")

public interface UserClient {

    @GetMapping("user/email")
    UserRequest findByEmail(@RequestParam("email") String email,
                            @RequestHeader("Authorization") String token );

}
