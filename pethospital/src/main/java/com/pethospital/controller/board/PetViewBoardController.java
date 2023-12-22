package com.pethospital.controller.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethospital.domain.board.PetViewBoard;
import com.pethospital.service.board.PetViewBoardService;

@RestController
public class PetViewBoardController {
	
	@Autowired
	PetViewBoardService petViewBoardService;
	
	// 좋아요 TOP6 게시글 
	@GetMapping("/toplike")
	public List<PetViewBoard> topLike() {
		return petViewBoardService.sixLike();
	}
	
	// 최신 게시글 5개
	@GetMapping("/recentpost")
	public List<PetViewBoard> recentPost(){
		return petViewBoardService.fivePost();
	}
}
