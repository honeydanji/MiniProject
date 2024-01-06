package com.pethospital.domain.board;

import com.pethospital.domain.MemberEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="Pet_board_like")
public class PetBoardLike {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int likeId;
	
	@ManyToOne // 다대원 방식
	@JoinColumn(name = "id") // 폴인키로 묶을 때 사용!
	private MemberEntity petMember;
	
	@ManyToOne
	@JoinColumn(name = "free_board_id")
	private PetFreeBoard petFreeBoard;
	
	@ManyToOne
	@JoinColumn(name = "honey_board_id")
	private PetHoneyBoard petHoneyBoard;
	
}
