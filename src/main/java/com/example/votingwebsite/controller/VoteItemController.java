package com.example.votingwebsite.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.votingwebsite.dto.VoteItemDTO;
import com.example.votingwebsite.model.VoteItem;

import com.example.votingwebsite.service.VoteService;

@RestController
@RequestMapping("/voteItem")
public class VoteItemController {

    @Autowired
    private VoteService voteService;



    @PostMapping
    public ResponseEntity<String> createVoteItem(@RequestBody VoteItemDTO dto) {
        String voteItemTitle = dto.getTitle();
        if (voteItemTitle == null || voteItemTitle.trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("投票項目標題不能為空");
        }
        System.out.println("新增投票項目: " + voteItemTitle);
        try {
            voteService.addVoteItem(voteItemTitle);
            return ResponseEntity.status(HttpStatus.CREATED).body("新增成功");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("新增失敗: " + e.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateVoteItem(@PathVariable Long id,
            @RequestBody VoteItemDTO dto) {
        String newTitle = dto.getTitle();
        if (newTitle == null || newTitle.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("標題不能為空");
        }
        try {
            voteService.updateVoteItem(id, newTitle);
            return ResponseEntity.ok("更新成功");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("更新失敗: " + e.getMessage());
        }
    }


    @GetMapping("/all")
    public ResponseEntity<Object> getAllVoteItems() {
        try {
            List<VoteItem> voteItems = voteService.findAllVoteItem();
            return ResponseEntity.ok(voteItems);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
