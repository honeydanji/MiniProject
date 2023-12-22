package com.pethospital.repository.reply;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pethospital.domain.reply.PetFreeReply;

public interface PetFreeReplyRepository extends JpaRepository<PetFreeReply, Integer> {
    
	
	// 댓글 번호 객체 저장
	PetFreeReply findByCommentId(int commentId);
	
	// 댓글 삭제
	void deleteByCommentId(int commentId);
}
