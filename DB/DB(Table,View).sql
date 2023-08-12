-- 펫 자유 게시판 테이블 생성
CREATE TABLE pet_free_board (
  free_board_id int NOT NULL AUTO_INCREMENT,
  user_id varchar(255),
  nickname varchar(255),
  title varchar(255) NOT NULL,
  content varchar(255) NOT NULL,
  regdate varbinary(255) DEFAULT NULL,
  updatedate varbinary(255) DEFAULT NULL,
  deletedate varbinary(255) DEFAULT NULL,
  imagefile varchar(255) DEFAULT NULL,
  likes int DEFAULT '0',
  views int DEFAULT '0',
  PRIMARY KEY (free_board_id),
  KEY user_id (user_id),
  CONSTRAINT pet_free_board_ibfk_1 FOREIGN KEY (user_id) REFERENCES pet_member (user_id) ON DELETE CASCADE
);

-- 펫 자유 게시판 댓글 테이블 생성
CREATE TABLE pet_free_reply (
  comment_id bigint NOT NULL AUTO_INCREMENT,
  free_board_id int NOT NULL,
  user_id varchar(255),
  nickname varchar(255),
  contents varchar(255) NOT NULL,
  registration_date varbinary(255) DEFAULT NULL,
  PRIMARY KEY (comment_id),
  KEY free_board_id (free_board_id),
  KEY user_id (user_id),
  CONSTRAINT pet_free_reply_ibfk_1 FOREIGN KEY (free_board_id) REFERENCES pet_free_board (free_board_id) ON DELETE CASCADE,
  CONSTRAINT pet_free_reply_ibfk_2 FOREIGN KEY (user_id) REFERENCES pet_member (user_id) ON DELETE CASCADE
);

-- 펫 허니 게시판 테이블 생성
CREATE TABLE pet_honey_board (
  honey_board_id int NOT NULL AUTO_INCREMENT,
  user_id varchar(255),
  nickname varchar(255),
  title varchar(255) NOT NULL,
  content varchar(255) NOT NULL,
  regdate varbinary(255) DEFAULT NULL,
  updatedate varbinary(255) DEFAULT NULL,
  deletedate varbinary(255) DEFAULT NULL,
  imagefile varchar(255) DEFAULT NULL,
  likes int DEFAULT '0',
  views int DEFAULT '0',
  PRIMARY KEY (honey_board_id),
  KEY user_id (user_id),
  CONSTRAINT pet_honey_board_ibfk_1 FOREIGN KEY (user_id) REFERENCES pet_member (user_id) ON DELETE CASCADE
);

-- 펫 허니 게시판 댓글 테이블 생성
CREATE TABLE pet_honey_reply (
  comment_id bigint NOT NULL AUTO_INCREMENT,
  honey_board_id int NOT NULL,
  user_id varchar(255),
  nickname varchar(255),
  contents varchar(255) NOT NULL,
  registration_date varbinary(255) DEFAULT NULL,
  PRIMARY KEY (comment_id),
  KEY honey_board_id (honey_board_id),
  KEY user_id (user_id),
  CONSTRAINT pet_honey_reply_ibfk_1 FOREIGN KEY (honey_board_id) REFERENCES pet_honey_board (honey_board_id) ON DELETE CASCADE,
  CONSTRAINT pet_honey_reply_ibfk_2 FOREIGN KEY (user_id) REFERENCES pet_member (user_id) ON DELETE CASCADE
);

-- 게시물 좋아요 테이블 생성
CREATE TABLE Pet_board_like (
    likeId INT PRIMARY KEY AUTO_INCREMENT,
    id INT,
    free_board_id INT,
    honey_board_id INT,
    FOREIGN KEY (id) REFERENCES Pet_member(id),
    FOREIGN KEY (free_board_id) REFERENCES Pet_free_board(free_board_id),
    FOREIGN KEY (honey_board_id) REFERENCES Pet_honey_board(honey_board_id)
);

-- 댓글 테이블들을 합친 뷰 생성
CREATE VIEW Combined_Reply AS
SELECT 'pet_free_reply' AS source, comment_id, free_board_id AS board_id, user_id, nickname, contents, registration_date, updatedate FROM pet_free_reply
UNION ALL
SELECT 'pet_honey_reply' AS source, comment_id, honey_board_id AS board_id, user_id, nickname, contents, registration_date, updatedate FROM pet_honey_reply;

-- 게시물 테이블들을 합친 뷰 생성
CREATE VIEW Combined_Boards AS
SELECT 'pet_free_board' AS source, free_board_id AS id, user_id, nickname, title, content, regdate, updatedate, deletedate, imagefile, views, likes FROM pet_free_board
UNION ALL
SELECT 'pet_honey_board' AS source, honey_board_id AS id, user_id, nickname, title, content, regdate, updatedate, deletedate, imagefile, views, likes FROM pet_honey_board;