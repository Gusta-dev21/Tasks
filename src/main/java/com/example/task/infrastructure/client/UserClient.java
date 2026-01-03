package com.example.task.infrastructure.client;


import com.example.task.infrastructure.entity.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="user",url="${user.url}")

public interface UserClient {

    @GetMapping("/email")
    UserResponse findByEmail(@RequestParam("email") String email,
                             @RequestHeader("Authorization") String token );

}
