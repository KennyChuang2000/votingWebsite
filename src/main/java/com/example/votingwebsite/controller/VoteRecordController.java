package com.example.votingwebsite.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.votingwebsite.dto.VoteRequest;
import com.example.votingwebsite.model.VoteRecord;
import com.example.votingwebsite.service.VoteService;

@RestController
@RequestMapping("/voteRecord")
public class VoteRecordController {

    @Autowired
    private VoteService voteService;

    @GetMapping
    public ResponseEntity<Object> getUserVote() {
        try {
            List<VoteRecord> voteRecords = voteService.getUserVote();
            return ResponseEntity.ok(voteRecords);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<String> addvoteRecords(@RequestBody VoteRequest voteRequest) {
        try {
            voteService.submitVotes(voteRequest.getVoteItemIds());
            return ResponseEntity.ok("投票成功");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("投票失敗: " + e.getMessage());
        }
    }


}
