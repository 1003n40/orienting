package com.orienting.orienting.spring.controller;

import com.orienting.common.entity.CoachEntity;
import com.orienting.common.entity.UserEntity;
import com.orienting.common.repository.ClubRepository;
import com.orienting.common.repository.CoachRepository;
import com.orienting.common.repository.ContestRepository;
import com.orienting.common.repository.UserRepository;
import com.orienting.common.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private ContestRepository contestRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/asd", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> get() {
        Map<String, ?> response = Map.of( //
                "users", userRepository.findAll(), //
                "clubs", clubRepository.findAll(), //
                "coaches", coachRepository.findAll(), //
                "contests", contestRepository.findAll()
        );
        return ResponseEntity.ok(response);
    }
}
