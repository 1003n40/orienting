package com.orienting.common.repository;

import com.orienting.common.entity.ContestEntity;
import com.orienting.common.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findUserEntityByContests(ContestEntity contestEntity);

    Set<UserEntity> findUserEntitiesByContests(ContestEntity contestEntity);


}
