package com.orienting.common.repository;

import com.orienting.common.entity.ClubEntity;
import com.orienting.common.entity.ContestEntity;
import com.orienting.common.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    @Query("select u from UserEntity u join u.club c where c.id = :clubId")
    Set<UserEntity> findAllByClubId(String clubId);

    @Query("select u from UserEntity u join u.contests c where c.id = :contestId")
    Set<UserEntity> findAllByContestId(String contestId);
}
