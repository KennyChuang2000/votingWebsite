package com.example.votingwebsite.repository;

import com.example.votingwebsite.model.User;
import com.example.votingwebsite.model.VoteItem;
import com.example.votingwebsite.model.VoteRecord;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRecordRepository extends JpaRepository<VoteRecord, Long> {
    List<VoteRecord> findByUser(User user);

    boolean existsByUserAndVoteItem(User user, VoteItem voteItem);

    void deleteByUserAndVoteItem(User user, VoteItem voteItem);

    void deleteByUser(User user);
}
