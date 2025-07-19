package com.example.votingwebsite.model;

import lombok.Setter;
import lombok.Getter;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Getter
@Setter
@Entity
public class VoteItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    // @Column(name = "created_at", updatable = false)
    // private LocalDateTime createdAt;

    // 投票紀錄清單（可選）
    // @OneToMany(mappedBy = "voteItem", cascade = CascadeType.ALL)
    // private List<VoteRecord> voteRecords = new ArrayList<>();
}
