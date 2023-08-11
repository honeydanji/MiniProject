package com.pethospital.service.reply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pethospital.domain.reply.Pet_view_reply;
import com.pethospital.repository.reply.Pet_view_reply_Repository;

@Service
public class Pet_view_reply_service {
	
	@Autowired
	Pet_view_reply_Repository petViewReplyRepository;
	
	public List<Pet_view_reply> fiveReply(){
		return petViewReplyRepository.findRecentReply();
	}

}
