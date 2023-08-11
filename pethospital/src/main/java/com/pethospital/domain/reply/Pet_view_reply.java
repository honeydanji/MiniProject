package com.pethospital.domain.reply;

import java.util.Date;

import javax.annotation.concurrent.Immutable;

import org.hibernate.annotations.Subselect;

import jakarta.persistence.Column;
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

@Entity
@Immutable // 이 엔티티는 읽기 전용입니다 (뷰)
@Subselect("SELECT * FROM Combined_Reply") // 뷰 이름을 맞게 수정
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@SqlResultSetMapping(name = "CombinedReplyMapping", entities = @EntityResult(entityClass = Pet_view_reply.class))
public class Pet_view_reply {

	private String source;
	
	@Id
	@Column(name = "comment_id")
	private int id;
	
	@Column(name = "board_id")
	private int boardId;
	
	@Column(name = "user_id")
	private String userId;
	
	private String nickname;
	private String contents;
	
	@Column(name = "registration_date")
	private Date registrationDate;
	private Date updatedate;
	
}
