package com.orienting.common.services;

import com.orienting.common.entity.UserEntity;
import com.orienting.common.repository.UserRepository;

import java.util.List;

public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> listUsers() {
        return userRepository.findAll();
    }

    public UserEntity createUser() {
        UserEntity entity = new UserEntity("sd", "testid", "idtype", "asd", "asd", "asd", "asd", "trainer");
        return userRepository.save(entity);
    }
}
