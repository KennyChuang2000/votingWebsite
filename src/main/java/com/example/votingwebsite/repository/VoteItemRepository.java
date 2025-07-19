package com.example.votingwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.votingwebsite.model.VoteItem;

@Repository
public interface VoteItemRepository extends JpaRepository<VoteItem, Long> {
    @Procedure("sp_add_vote_item")
    void insertVoteItem(@Param("p_title") String title);

    @Procedure("sp_update_vote_item")
    void updateVoteItem(@Param("p_id") Long id, @Param("p_title") String newTitle);



}
