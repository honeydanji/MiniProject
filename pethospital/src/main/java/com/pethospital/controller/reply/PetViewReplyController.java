package com.pethospital.controller.reply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethospital.domain.reply.PetViewReply;
import com.pethospital.service.reply.PetViewReplyService;

@RestController
public class PetViewReplyController {

	
	@Autowired
	PetViewReplyService petViewReplyService;
	
	// 최신 댓글 5개
	@GetMapping("/recentreply")
	public List<PetViewReply> recentReply(){
		return petViewReplyService.fiveReply();
	}
}
