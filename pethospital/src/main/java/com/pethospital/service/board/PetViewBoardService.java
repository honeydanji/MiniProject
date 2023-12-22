package com.pethospital.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pethospital.domain.board.PetViewBoard;
import com.pethospital.repository.board.PetViewBoardRepository;

@Service
public class PetViewBoardService {
	
	@Autowired
	PetViewBoardRepository petViewBoardRepository;
	
	// 좋아요 TPO5 게시글
	public List<PetViewBoard> sixLike() {
		return petViewBoardRepository.findTopLikedPosts();
	}
	
	// 최신 게시글 5개
	
	public List<PetViewBoard> fivePost() {
		return petViewBoardRepository.findRecentBoards();
	}

}
