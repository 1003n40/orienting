package com.orienting.common.repository;

import com.orienting.common.entity.ContestEntity;
import com.orienting.common.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContestRepository extends JpaRepository<ContestEntity, String> {
}
