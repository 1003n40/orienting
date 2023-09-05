package com.orienting.common.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;
import java.util.Set;

@Data
@Entity
@Table(name = "contests")
public class ContestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private Instant date;

    @Column(name = "location")
    private String location;

    @ManyToMany
    @JoinTable(
            name = "users_contests", //
            joinColumns = @JoinColumn(name = "contest_id"), //
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @JsonBackReference
    // When serializing the object we should use DTOs, when not using DTOs for testing for example use @JsonManagedReference
    // or @JsonBackReference, otherwise it will make indefinite recursion while serializing.
    private Set<UserEntity> users;
}
