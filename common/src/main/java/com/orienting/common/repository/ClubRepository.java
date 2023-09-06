package com.orienting.common.repository;

import com.orienting.common.entity.ClubEntity;
import com.orienting.common.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClubRepository extends JpaRepository<ClubEntity, String> {
}
