DELETE FROM vote_record;
ALTER TABLE vote_record AUTO_INCREMENT = 1;

DELETE FROM vote_item;
ALTER TABLE vote_item AUTO_INCREMENT = 1;

DELETE FROM `user`;

-- 使用者初始資料
INSERT INTO user (id, username, password, roles, display_name) VALUES
('384e4548-1871-4358-8339-78f388672d38', 'Frank', '$2a$10$K2oqaVde9kynPuq1G8Yt5ugv/jqrk8tRSvYsPFGYcXc69rQZkvZhu', 'ROLE_USER', 'Frank1'),
('b6b8d6e5-9a91-48e3-9f9e-85c7a9f5e834', 'Leo',   '$2a$10$K2oqaVde9kynPuq1G8Yt5ugv/jqrk8tRSvYsPFGYcXc69rQZkvZhu', 'ROLE_USER', 'Leo'),
('7d3d1d1a-9f84-4f90-83c0-3eb953e4e9b6', 'Sandy', '$2a$10$K2oqaVde9kynPuq1G8Yt5ugv/jqrk8tRSvYsPFGYcXc69rQZkvZhu', 'ROLE_USER', 'Sandy'),
('9c35d9c9-559e-4c57-b06f-4f89a3a6d17c', 'Randy', '$2a$10$K2oqaVde9kynPuq1G8Yt5ugv/jqrk8tRSvYsPFGYcXc69rQZkvZhu', 'ROLE_USER', 'Randy');


-- 投票項目初始資料
INSERT INTO vote_item (title) VALUES 
('PC'),
('Mouse');

-- 投票紀錄初始資料
INSERT INTO vote_record (username, vote_item_id)
VALUES ('Leo', 1),
       ('Sandy', 1),
       ('Sandy', 2),
       ('Randy', 2);


