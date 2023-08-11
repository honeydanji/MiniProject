package com.pethospital.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pethospital.domain.board.Pet_view_board;
import com.pethospital.repository.board.Pet_view_board_Repository;

@Service
public class Pet_view_board_Service {
	
	@Autowired
	Pet_view_board_Repository petViewBoardRepository;
	
	// 좋아요 TPO5 게시글
	public List<Pet_view_board> sixLike() {
		return petViewBoardRepository.findTopLikedPosts();
	}
	
	// 최신 게시글 5개
	
	public List<Pet_view_board> fivePost() {
		return petViewBoardRepository.findRecentBoards();
	}

}
