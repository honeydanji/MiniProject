package com.pethospital.service.reply;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pethospital.domain.MemberEntity;
import com.pethospital.domain.board.PetHoneyBoard;
import com.pethospital.domain.reply.PetHoneyReply;
import com.pethospital.repository.MemberRepository;
import com.pethospital.repository.board.PetHoneyBoardRepository;
import com.pethospital.repository.reply.PetHoneyReplyRepository;

@Service
public class PetHoneyReplyService {

	@Autowired
	PetHoneyReplyRepository petHoneyReplyRepository;
	
	@Autowired
	PetHoneyBoardRepository petHoneyBoardRepository;
	
	@Autowired
	MemberRepository petMemberRepository;
	
	// 전체 댓글 조회
	public List<PetHoneyReply> allReadHoneyReply(){
		return petHoneyReplyRepository.findAll();
	}
	
	// 댓글 작성
	@Transactional
	public ResponseEntity<String> createReply(int honeyBoardId, // 게시판 번호
											  PetHoneyReply reply, // 댓글 내용
											  String userId){ // 유저 아이디
			
		// userId에 해당하는 객체 불러오기
		MemberEntity petMember = petMemberRepository.findByUserId(userId);
		// freeBoardId 해당하는 객체 불러오기
		PetHoneyBoard petHoneyBoard = petHoneyBoardRepository.findByHoneyBoardId(honeyBoardId);
			
		// 1-1. 게시글이 존재 할 때..
		if(petHoneyBoard != null) {
			// 객체 생성
			PetHoneyReply petHoneyReply = new PetHoneyReply();
			
			petHoneyReply.setContents(reply.getContents()); // 댓글 내용 저장
			petHoneyReply.setNickname(petMember.getNickname()); // userId에 해당하는 닉네임 저장.
			petHoneyReply.setUserId(userId); // 유저 아이디 저장
			petHoneyReply.setHoneyBoardId(petHoneyBoard); // 게시글과 댓글의 관계 설정
			petHoneyReply.setRegistrationDate(new Date());
			petHoneyReplyRepository.save(petHoneyReply); // 댓글 정보 DB 저장
			
			return ResponseEntity.ok("댓글 작성 성공");							
		}else {//1-2. 게시글이 존재하지 않을 때
			return ResponseEntity.ok("게시글이 존재 하지 않습니다.");
		}
	}
		
	// 댓글 수정
	@Transactional
	public ResponseEntity<String> updateReply(int commentId,
											  PetHoneyReply reply,
											  String userId){
		
		// 1. 댓글 작성 아이디와 수정 시도 아이디와 일치하는 지 확인해야함.
		PetHoneyReply petHoneyReply = petHoneyReplyRepository.findByCommentId(commentId);
		
		if(!userId.equals(petHoneyReply.getUserId())) {
			return ResponseEntity.ok("본인 댓글 수정이 가능합니다.");
		}else {
			petHoneyReply.setContents(reply.getContents()); // 댓글 내용 수정
			petHoneyReply.setUpdatedate(new Date()); // 댓글 수정 일자
			petHoneyReplyRepository.save(petHoneyReply); // 수정된 객체 저장
			return ResponseEntity.ok("수정이 완료되었습니다.");
		}
	}
		
	// 댓글 삭제
	@Transactional
	public ResponseEntity<String> deleteReply(int commentId,
											  PetHoneyReply reply,
											  String userId){
			
		// 댓글 작성 아이디와 삭제 시도 아이디와 일치하는 지 확인
		PetHoneyReply petHoneyReply = petHoneyReplyRepository.findByCommentId(commentId);
			
		if(!userId.equals(petHoneyReply.getUserId())) {
			return ResponseEntity.ok("본인 댓글만 삭제 가능합니다.");
		}else {
			petHoneyReplyRepository.deleteByCommentId(commentId); // 지정한 댓글 삭제
			return ResponseEntity.ok("삭제가 완료되었습니다.");
		}
			
	}
}
