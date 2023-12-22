package com.pethospital.repository.board;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pethospital.domain.board.PetFreeBoard;

public interface PetFreeBoardRepository extends JpaRepository<PetFreeBoard, Integer>{
 
	// 게시글등록 
	// -> save
	
	// 전체 게시글 조회 
	// -> findAll

	// 특정 게시글 조회
	//Pet_free_board findByTitle(String title);
	
	// 게시글 수정
	// -> save
	
	// 게시글 삭제
	void deleteByFreeBoardId(int freeBoardId);
	
	// 게시글 번호로 게시글 찾기(조회, 수정, 삭제, 좋아요)
	PetFreeBoard findByFreeBoardId(int freeBoardId);
	
}
