package com.pethospital.service.reply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pethospital.domain.reply.PetViewReply;
import com.pethospital.repository.reply.PetViewReplyRepository;

@Service
public class PetViewReplyService {
	
	@Autowired
	PetViewReplyRepository petViewReplyRepository;
	
	public List<PetViewReply> fiveReply(){
		return petViewReplyRepository.findRecentReply();
	}

}
