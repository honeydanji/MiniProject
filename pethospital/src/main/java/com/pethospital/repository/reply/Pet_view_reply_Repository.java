package com.pethospital.repository.reply;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pethospital.domain.reply.Pet_view_reply;

public interface Pet_view_reply_Repository extends JpaRepository<Pet_view_reply, Integer>{
	
	// 최신 댓글 5개
	@Query(value = "SELECT * FROM Combined_Reply ORDER BY registration_date DESC LIMIT 5", nativeQuery = true)
	List<Pet_view_reply> findRecentReply();
}
