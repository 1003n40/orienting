package com.orienting.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "identifier")
    private String identifier;

    @Column(name = "identifier_type")
    private String identifierType;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "ucn")
    private String ucn;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "role")
    private String role;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( //
            name = "users_contests", //
            joinColumns = @JoinColumn(name = "user_id"), //
            inverseJoinColumns = @JoinColumn(name = "contest_id") //
    )
    @JsonManagedReference
    // When serializing the object we should use DTOs, when not using DTOs for testing for example use @JsonManagedReference
    // or @JsonBackReference, otherwise it will make indefinite recursion while serializing.
    private Set<ContestEntity> contests;

    @ManyToMany
    @JoinTable(
            name = "users_clubs", //
            joinColumns = @JoinColumn(name = "user_id"), //
            inverseJoinColumns = @JoinColumn(name = "club_id")
    )
    @JsonManagedReference
    // When serializing the object we should use DTOs, when not using DTOs for testing for example use @JsonManagedReference
    // or @JsonBackReference, otherwise it will make indefinite recursion while serializing.
    private Set<ClubEntity> clubs;

    public UserEntity() {
    }

    public UserEntity(
            String passwordHash,
            String identifier,
            String identifierType,
            String firstName,
            String lastName,
            String ucn,
            String phoneNumber,
            String role
    ) {
        this.passwordHash = passwordHash;
        this.identifier = identifier;
        this.identifierType = identifierType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ucn = ucn;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }
}
