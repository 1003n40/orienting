package com.orienting.orienting.spring.controller;

import com.orienting.common.entity.UserEntity;
import com.orienting.common.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/test")
public class TestController {

    public UserService userService;

    public TestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/asd")
    public ResponseEntity<?> get() {
        List<UserEntity> entityList = userService.listUsers();
        return ResponseEntity.ok(Map.of("users", entityList));
    }
}
