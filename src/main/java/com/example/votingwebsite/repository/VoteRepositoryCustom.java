package com.example.votingwebsite.repository;


import com.example.votingwebsite.dto.VoteItemDTO;
import com.example.votingwebsite.dto.VoteSummaryDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VoteRepositoryCustom {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<VoteSummaryDTO> getVoteSummary() {
        return jdbcTemplate.query("CALL sp_vote_count_summary()",
                (rs, rowNum) -> new VoteSummaryDTO(rs.getLong("id"), rs.getString("title"),
                        rs.getInt("voteCount")));
    }


}

