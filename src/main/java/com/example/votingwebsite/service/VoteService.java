package com.example.votingwebsite.service;

import java.util.List;
import com.example.votingwebsite.dto.VoteSummaryDTO;
import com.example.votingwebsite.model.VoteItem;
import com.example.votingwebsite.model.VoteRecord;


public interface VoteService {

    public List<VoteSummaryDTO> getVoteSummary();

    public void addVoteItem(String title) throws Exception;

    public void updateVoteItem(Long id, String title) throws Exception;

    public List<VoteItem> findAllVoteItem() throws Exception;

    public List<VoteRecord> getUserVote() throws Exception;

    public void submitVotes(List<Long> voteItemIds) throws Exception;

}
