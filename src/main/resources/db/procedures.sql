DELIMITER $$

CREATE PROCEDURE sp_vote_count_summary()
BEGIN
    SELECT vi.id, vi.title, COUNT(vr.id) AS voteCount
    FROM vote_item vi
    LEFT JOIN vote_record vr ON vi.id = vr.vote_item_id
    GROUP BY vi.id, vi.title;
END $$

DELIMITER ;

DELIMITER  $$

CREATE PROCEDURE sp_add_vote_item(
    IN p_title VARCHAR(255)
)
BEGIN
    INSERT INTO vote_item (title)
    VALUES (p_title);
END  $$

DELIMITER ;

DELIMITER  $$

CREATE PROCEDURE sp_update_vote_item(
    IN p_id INT,
    IN p_title VARCHAR(255)
)
BEGIN
    UPDATE vote_item
    SET title = p_title
    WHERE id = p_id;
END  $$

DELIMITER ;
