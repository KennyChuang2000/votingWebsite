-- 投票項目表
CREATE TABLE IF NOT EXISTS vote_item (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '投票項目編號',
    title VARCHAR(255) NOT NULL COMMENT '投票項目名稱'
);

-- 投票紀錄表
CREATE TABLE IF NOT EXISTS vote_record (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '紀錄流水號',
    username VARCHAR(100) NOT NULL COMMENT '投票人帳號',
    vote_item_id BIGINT NOT NULL COMMENT '投票項目編號',
    FOREIGN KEY (username) REFERENCES user(username),
    FOREIGN KEY (vote_item_id) REFERENCES vote_item(id)
);

-- 使用者表
CREATE TABLE IF NOT EXISTS `user` (
  id CHAR(36) PRIMARY KEY DEFAULT (UUID()),
  username VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(100) NOT NULL,
  roles VARCHAR(20) NOT NULL DEFAULT 'ROLE_USER',
  display_name VARCHAR(100)
);