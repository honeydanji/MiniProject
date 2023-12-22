package com.pethospital.controller.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pethospital.service.board.PetBoardLikeService;

@RestController
public class PetBoardLikeController {
	
	@Autowired
	PetBoardLikeService petBoardLikeService;
	
	// "좋아요" 기능 구현
	@Transactional
	@GetMapping("/like/{boardName}/{boardId}")
	public Object boardLike(@PathVariable String boardName, @PathVariable int boardId,
							Authentication authentication) {
		// 좋아요 버튼을 누르면 아래와 같은 데이터가 백으로 온다...
		// 1. 권한이 있는 가? >> authentication And 누가 눌렀는 가?(userId)
		// 2. 어떤 게시판인가? >> boardName >> 프론트에서 free or honey를 보내준다. 
		// 3. 몇번 게시글인가? >> boardId
		
		// int boardId = Integer.parseInt(boardIdStr);

		String userId = authentication.getName(); // 권한에서 userId 추출
		
		return petBoardLikeService.boardLikeOnOff(userId, boardName, boardId);
	}

	// 특정 계정이 "좋아요" 누른 게시글 
	@Transactional
	@GetMapping("/like/{boardName}")
	public Object boardLikeAll(@PathVariable String boardName, Authentication authentication) {
		// 해당 유저가 누른 좋아요 게시글에 대한 모든 정보를 리턴
		String userId = authentication.getName(); // 권한에서 userId 추출
		return petBoardLikeService.likeAll(userId, boardName);
	}
}
