package com.orienting.orienting.spring.configuration;

import com.orienting.common.repository.UserRepository;
import com.orienting.common.services.UserService;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = { //
        "com.orienting.common.repository" //
})
@EntityScan(basePackages = { //
        "com.orienting.common.entity" //
})
public class BeanConfiguration {

    @Bean
    public UserService userService(UserRepository repository) {
        return new UserService(repository);
    }
}
