package com.example.votingwebsite.dto;

import lombok.Data;

@Data
public class VoteSummaryDTO {
    private Long id;
    private String title;
    private int voteCount;

    // Constructors
    public VoteSummaryDTO() {}

    public VoteSummaryDTO(Long id, String title, int voteCount) {
        this.id = id;
        this.title = title;
        this.voteCount = voteCount;
    }

    // Getters / Setters
}
