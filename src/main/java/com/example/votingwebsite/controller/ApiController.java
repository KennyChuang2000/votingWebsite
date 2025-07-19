package com.example.votingwebsite.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.votingwebsite.dto.VoteSummaryDTO;
import com.example.votingwebsite.service.VoteService;

@RestController
@RequestMapping("/votes")
public class ApiController {

    @Autowired
    private VoteService voteService;

    @GetMapping("/summary")
    public List<VoteSummaryDTO> getVoteSummary() {
        return voteService.getVoteSummary();
    }
}
