package com.pethospital.domain.reply;

import java.util.Date;


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
import org.hibernate.annotations.Immutable;

@Entity
@Immutable // 이 엔티티는 읽기 전용입니다 (뷰)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@SqlResultSetMapping(name = "CombinedReplyMapping", entities = @EntityResult(entityClass = PetViewReply.class))
public class PetViewReply {

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
