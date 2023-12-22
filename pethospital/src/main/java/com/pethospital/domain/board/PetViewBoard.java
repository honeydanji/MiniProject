package com.pethospital.domain.board;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.EntityResult;
import jakarta.persistence.Id;
import jakarta.persistence.SqlResultSetMapping;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable // 이 엔티티는 읽기 전용입니다 (뷰)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@SqlResultSetMapping(name = "CombinedBoardMapping", entities = @EntityResult(entityClass = PetViewBoard.class))
public class PetViewBoard {

	private String source;
	
	@Id
	private int id; // ID 열로 사용될 변수
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

	//@SqlResultSetMapping(name = "CombinedBoardMapping", entities = @EntityResult(entityClass = Pet_view_board.class))
	//@Subselect("SELECT * FROM Combined_Boards") // 뷰 이름을 맞게 수정
