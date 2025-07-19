package com.example.votingwebsite.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.votingwebsite.dto.VoteSummaryDTO;
import com.example.votingwebsite.model.User;
import com.example.votingwebsite.model.VoteItem;
import com.example.votingwebsite.model.VoteRecord;
import com.example.votingwebsite.repository.UserRepository;
import com.example.votingwebsite.repository.VoteItemRepository;
import com.example.votingwebsite.repository.VoteRecordRepository;
import com.example.votingwebsite.repository.VoteRepositoryCustom;
import jakarta.transaction.Transactional;


@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteRepositoryCustom voteRepositoryCustom;
    @Autowired
    private VoteItemRepository voteItemRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private VoteRecordRepository voteRecordRepository;

    public void newUser(User user) throws Exception {
        userService.registerUser(user);
    }

    public List<VoteSummaryDTO> getVoteSummary() {
        return voteRepositoryCustom.getVoteSummary();
    }

    @Transactional
    public void addVoteItem(String title) throws Exception {
        voteItemRepository.insertVoteItem(title);
    }

    @Transactional
    public void updateVoteItem(Long id, String newTitle) throws Exception {
        voteItemRepository.updateVoteItem(id, newTitle);
    }

    public List<VoteItem> findAllVoteItem() throws Exception {
        return voteItemRepository.findAll();
    }

    public List<VoteRecord> getUserVote() throws Exception {
        List<VoteRecord> result = voteRecordRepository.findByUser(userService.getCurrentUser());
        return result;
    }

    @Transactional
    public void submitVotes(List<Long> voteItemIds) throws Exception {
        User currentUser = userService.getCurrentUser();
        if (currentUser == null) {
            throw new RuntimeException("使用者未登入");
        }

        voteRecordRepository.deleteByUser(currentUser);

        for (Long voteItemId : voteItemIds) {
            VoteItem item = voteItemRepository.findById(voteItemId)
                    .orElseThrow(() -> new RuntimeException("無效的投票項目: " + voteItemId));

            // 新增投票記錄
            VoteRecord record = new VoteRecord();
            record.setUser(currentUser);
            record.setVoteItem(item);
            voteRecordRepository.save(record);
        }
    }



}
