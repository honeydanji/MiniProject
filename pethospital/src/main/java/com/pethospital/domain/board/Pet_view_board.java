package com.pethospital.domain.board;

import java.util.Date;

import javax.annotation.concurrent.Immutable;
import javax.persistence.Table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "combined_boards")
@Immutable // 이 엔티티는 읽기 전용입니다 (뷰)
//@Subselect("SELECT * FROM Combined_Boards") // 뷰 이름을 맞게 수정
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
//@SqlResultSetMapping(name = "CombinedBoardMapping", entities = @EntityResult(entityClass = Pet_view_board.class))
public class Pet_view_board {

	private String source;
	
	@Id
	private int id; // ID 열로 사용될 변수
	@Column(name = "user_id")
	private String userId;
	private String nickname;
	private String title;
	private String content;
	private Date regdate;
	private Date updatedate;
	private Date deletedate;
	private String imagefile;
	private int views;
	private int likes;
}