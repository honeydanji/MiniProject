package com.pethospital.service.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pethospital.domain.PetMember;
import com.pethospital.domain.board.PetBoardLike;
import com.pethospital.domain.board.PetFreeBoard;
import com.pethospital.domain.board.PetHoneyBoard;
import com.pethospital.repository.PetMemberRepository;
import com.pethospital.repository.board.PetBoardLikeRepository;
import com.pethospital.repository.board.PetFreeBoardRepository;
import com.pethospital.repository.board.PetHoneyBoardRepository;

@Service
public class PetBoardLikeService {

	@Autowired
	PetBoardLikeRepository petBoardLikeRepository; // 좋아요 테이블
	
	@Autowired
	PetMemberRepository petMemberRepository; // 멤버

	@Autowired
	PetFreeBoardRepository petFreeBoardRepository; // 자유(자랑)게시판
	
	@Autowired
	PetHoneyBoardRepository petHoneyBoardRepository; // 꿀팁게시판

	// "좋아요" 기능 구현
	@Transactional
	public Object boardLikeOnOff(String userId, String boardName, int boardId){
		
		PetMember petMember = petMemberRepository.findByUserId(userId);
		
		if (boardName.equals("free")) {
			PetFreeBoard petFreeBoard = petFreeBoardRepository.findByFreeBoardId(boardId);
			if(petBoardLikeRepository.findByPetMemberAndPetFreeBoard(petMember, petFreeBoard) != null) {
				// 좋아요가 있으면 Off(레이블 삭제)
				petBoardLikeRepository.deleteByPetMemberAndPetFreeBoard(petMember, petFreeBoard);
				// 자유(자랑) 게시판 좋아요 - 1
				petFreeBoard.setLikes(petFreeBoard.getLikes() - 1);
				petFreeBoardRepository.save(petFreeBoard);

				return petFreeBoardRepository.findByFreeBoardId(boardId).getLikes();
				//return ResponseEntity.ok("FreeOff"); // 좋아요가 있으면 끈다.
			}else{
				// 좋아요가 없으면 On(레이블 생성)
				PetBoardLike petBoardLike = PetBoardLike.builder()
											.petMember(petMember)
											.petFreeBoard(petFreeBoard)
											.petHoneyBoard(null)
											.build();
				petBoardLikeRepository.save(petBoardLike);
				
				// 자유(자랑) 게시판 좋아요 + 1
				petFreeBoard.setLikes(petFreeBoard.getLikes() + 1);
				petFreeBoardRepository.save(petFreeBoard);

				System.out.println(boardId);

				return petFreeBoardRepository.findByFreeBoardId(boardId).getLikes(); // + userId + findAll()
				//return ResponseEntity.ok("FreeOn"); // 좋아요가 없으면 +1
			}
		}else if(boardName.equals("honey")) {
			PetHoneyBoard petHoneyBoard = petHoneyBoardRepository.findByHoneyBoardId(boardId);
			if(petBoardLikeRepository.findByPetMemberAndPetHoneyBoard(petMember, petHoneyBoard) != null) {
				// 좋아요가 있으면 Off(레이블 삭제)
				petBoardLikeRepository.deleteByPetMemberAndPetHoneyBoard(petMember, petHoneyBoard);
				
				// 꿀팁 게시판 좋아요 - 1
				petHoneyBoard.setLikes(petHoneyBoard.getLikes() - 1);
				petHoneyBoardRepository.save(petHoneyBoard);

				return petHoneyBoardRepository.findByHoneyBoardId(boardId).getLikes();
				//return ResponseEntity.ok("HoneyOff");
			}else {
				// 좋아요가 없으면 On(레이블 생성성)
				PetBoardLike petBoardLike = PetBoardLike.builder()
											.petMember(petMember)
											.petFreeBoard(null)
											.petHoneyBoard(petHoneyBoard)
											.build();
				petBoardLikeRepository.save(petBoardLike);
				
				// 꿀팁 게시판 좋아요 + 1
				petHoneyBoard.setLikes(petHoneyBoard.getLikes() + 1); 
				petHoneyBoardRepository.save(petHoneyBoard);

				return petHoneyBoardRepository.findByHoneyBoardId(boardId).getLikes();
				//return ResponseEntity.ok("HoneyOn");
			}
		}
		return null;
	}


	// 특정 계정이 "좋아요" 누른 게시글 
	@Transactional
	public Object likeAll(String userId, String boardName){

		PetMember petMember = petMemberRepository.findByUserId(userId);

		if((boardName.equals("free"))) {
			return petBoardLikeRepository.findByPetMemberAndPetFreeBoardIsNotNull(petMember);
		}else if((boardName.equals("honey"))) {
			return petBoardLikeRepository.findByPetMemberAndPetHoneyBoardIsNotNull(petMember);
		}
		return null;
	}
}
