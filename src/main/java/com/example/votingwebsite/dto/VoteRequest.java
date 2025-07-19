package com.example.votingwebsite.dto;

import java.util.List;
import lombok.Data;

@Data
public class VoteRequest {
    private List<Long> voteItemIds;
}

