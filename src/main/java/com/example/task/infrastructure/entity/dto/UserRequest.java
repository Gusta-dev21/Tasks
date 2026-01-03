package com.example.task.infrastructure.entity.dto;


import lombok.Builder;


public record UserRequest(String email,String password) {
}
