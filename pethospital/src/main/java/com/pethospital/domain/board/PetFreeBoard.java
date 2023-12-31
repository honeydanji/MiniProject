package com.pethospital.domain.board;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class PetFreeBoard {
    
	// 필수
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="free_board_id")
    private int freeBoardId;

    @Column(name="user_id")
    private String userId;
    private String nickname; 	// 게시글 닉네임
    
    @Column(nullable = false)
    private String title; 		// 게시글 제목
    
    @Column(nullable = false)
    private String content; 	// 게시글 내용
    
    // 선택
    private String imagefile; 	// 이미지파일 (여러개)
    
    private Date regdate;
    private Date updatedate;
    private Date deletedate;
    private int views; 			// 조회수
    private int likes;			// 좋아요
}
