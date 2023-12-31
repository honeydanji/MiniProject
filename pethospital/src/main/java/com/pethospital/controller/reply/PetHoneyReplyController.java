package com.pethospital.controller.reply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pethospital.domain.reply.PetHoneyReply;
import com.pethospital.service.reply.PetHoneyReplyService;

@RestController 
public class PetHoneyReplyController {

	@Autowired
	PetHoneyReplyService petHoneyReplyService;
	
	
	// 전체 댓글 조회 - 비회원, 회원
	@GetMapping("/honeyReply")
	public List<PetHoneyReply> allHoneyReply() {
		return petHoneyReplyService.allReadHoneyReply();
	}
	
	// 댓글 작성 - 회원
	@Transactional
	@PostMapping("/honeyReply/{honeyBoardId}")
	public ResponseEntity<String> createHoneyReply(@PathVariable int honeyBoardId, 
												   @RequestBody PetHoneyReply reply,
												   Authentication authentication) {
		// 1. 몇번 게시글인가?
		String userId = authentication.getName();	
		return petHoneyReplyService.createReply(honeyBoardId, reply, userId);
	}
	
	
	// 댓글 수정 - 회원
	@Transactional
	@PutMapping("/honeyReply/{commentId}")
	public ResponseEntity<String> updateHoneyReply(@PathVariable int commentId,
			  									   @RequestBody PetHoneyReply reply,
			  									   Authentication authentication) {
		// 1. 회원이 맞는가? Authentication
		// 2. 몇번 댓글인가? commentId
		// 3. 본인이 쓴 댓글이 맞는가? >> Service에서 구현
		String userId = authentication.getName();
		return petHoneyReplyService.updateReply(commentId, reply, userId);
	}
	
	
	// 댓글 삭제 - 회원
	@Transactional
	@DeleteMapping("/honeyReply/{commentId}")
	public ResponseEntity<String> deleteHoneyReply(@PathVariable int commentId,
			  									   @RequestBody PetHoneyReply reply,
			  									   Authentication authentication) {
		// 1. 회원이 맞는가? authentication
		// 2. 몇번 댓글인가? commentId
		// 3. 본인이 쓴 댓글이 맞는가?
		String userId = authentication.getName();
		return petHoneyReplyService.deleteReply(commentId, reply, userId);
	}
		
}
