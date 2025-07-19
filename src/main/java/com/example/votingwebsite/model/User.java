package com.example.votingwebsite.model;

import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {

    @Id
    @Column(length = 36)
    private String id = UUID.randomUUID().toString();

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    @JsonIgnore
    private String password;

    @Column(name = "roles")
    private String roles;

    @Column(name = "display_name")
    private String displayName;
}
