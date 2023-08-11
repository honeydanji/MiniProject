package com.pethospital.controller.reply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethospital.domain.reply.Pet_view_reply;
import com.pethospital.service.reply.Pet_view_reply_service;

@RestController
public class Pet_view_reply_controller {

	
	@Autowired
	Pet_view_reply_service petViewReplyService;
	
	// 최신 댓글 5개
	@GetMapping("/recentreply")
	public List<Pet_view_reply> recentReply(){
		return petViewReplyService.fiveReply();
	}
}
