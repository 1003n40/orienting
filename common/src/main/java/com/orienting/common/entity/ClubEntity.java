package com.orienting.common.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@Entity
@Table(name = "clubs")
public class ClubEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "club_name") // Could rename to name, as the table speaks enough
    private String name;

    @Column(name = "city")
    private String city;

    @ManyToMany
    @JoinTable(name = "users_clubs", //
            joinColumns = @JoinColumn(name = "club_id"), //
            inverseJoinColumns = @JoinColumn(name = "user_id") //
    )
    @JsonBackReference
    // When serializing the object we should use DTOs, when not using DTOs for testing for example use @JsonManagedReference
    // or @JsonBackReference, otherwise it will make indefinite recursion while serializing.
    private Set<UserEntity> users;

    @OneToMany(mappedBy = "club")
    @JsonManagedReference
    private Set<CoachEntity> coaches;
}
