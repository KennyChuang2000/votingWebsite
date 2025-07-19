package com.example.votingwebsite.dto;

import lombok.Data;

@Data
public class VoteItemDTO {
    private Long id;
    private String title;

    public VoteItemDTO(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    // getters and setters
}
