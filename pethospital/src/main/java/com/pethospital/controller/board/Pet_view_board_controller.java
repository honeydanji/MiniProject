package com.pethospital.controller.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethospital.domain.board.Pet_view_board;
import com.pethospital.service.board.Pet_view_board_Service;

@RestController
public class Pet_view_board_controller {
	
	@Autowired
	Pet_view_board_Service petViewBoardService;
	
	// 좋아요 TOP6 게시글 
	@GetMapping("/toplike")
	public List<Pet_view_board> topLike() {
		return petViewBoardService.sixLike();
	}
	
	// 최신 게시글 5개
	@GetMapping("/recentpost")
	public List<Pet_view_board> recentPost(){
		return petViewBoardService.fivePost();
	}
}
