package com.example.votingwebsite.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class VoteRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username") // FK 對應 User.username
    private User user;

    @ManyToOne
    @JoinColumn(name = "vote_item_id")
    private VoteItem voteItem;

    // @Column(name = "voted_at", updatable = false)
    // private LocalDateTime votedAt;
}
