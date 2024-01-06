package com.pethospital.service.board;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pethospital.domain.MemberEntity;
import com.pethospital.domain.board.PetFreeBoard;
import com.pethospital.dto.FreeBoardDto;
import com.pethospital.repository.MemberRepository;
import com.pethospital.repository.board.PetFreeBoardRepository;

import jakarta.transaction.Transactional;

@Service
public class PetFreeBoardService {

	// 이미지 파일의 기본 URL
	private final String imageBaseURL = "http://10.125.121.183:8080/free/images/";
	//private final String imageBaseURL = "http:/localhost:8080/honey/images/";   // 로컬

	@Autowired
	PetFreeBoardRepository petFreeBoardRepository;

	@Autowired
	MemberRepository petMemberRepository;
	
	// 게시글 등록
	public void createFreeService(PetFreeBoard petFreeBoard,
                                  MultipartFile imageFile,
                                  String userId) {
		// 게시글을 작성할 때 멤버정보(닉네임, 아이디)를 게시판 테이블에 저장한다.
		MemberEntity petMember = petMemberRepository.findByUserId(userId);
		
		// 로그인 유저 정보 게시글 ID, NickName 저장
		petFreeBoard.setUserId(petMember.getUserId());
		petFreeBoard.setNickname(petMember.getNickname());
		petFreeBoard.setRegdate(new Date());
		
		if (imageFile != null && !imageFile.isEmpty()) {
		    try {
		        String imageFileName = saveImage(imageFile);
		        petFreeBoard.setImagefile(imageBaseURL + imageFileName); // 이미지 파일 이름 설정
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
		petFreeBoardRepository.save(petFreeBoard);
	}
	
	// 이미지 저장 메서드
    private String saveImage(MultipartFile imageFile) throws IOException {
    	if (!imageFile.isEmpty()) {
            try {
                // 원본 파일 이름 가져오기
                String originalFilename = imageFile.getOriginalFilename();
                // 파일 저장 경로 설정 (필요에 따라 변경해주세요)
                String savePath = "C:/MiniProject/pethospital/Image/Free/";

                // 저장할 파일 객체 생성
                File savedFile = new File(savePath + originalFilename);

                // MultipartFile의 내용을 파일에 저장
                imageFile.transferTo(savedFile);

				return originalFilename;
                //return savePath + originalFilename; // 저장된 파일 이름 반환
            } catch (Exception e) {
                e.printStackTrace();
                // 예외 발생 시 null이나 다른 값을 반환하거나 처리하는 등의 방법 선택
            }
        }
        return null; // 파일이나 이미지가 없을 경우
    }
 	
	// 전체 게시글 조회
	public List<FreeBoardDto> allSelectFreeBoard() {
		// 모든 게시글 데이터를 데이터베이스에서 가져옴
		List<PetFreeBoard> freeBoards = petFreeBoardRepository.findAll();

		 // 게시글 목록을 각각의 FreeBoardDTO로 변환하고 이미지 URL을 포함시킨 DTO 리스트로 변환
        return freeBoards.stream()
            .map(this::createFreeBoardDTOWithImageUrl)
            .collect(Collectors.toList());
	}

	// 이미지 URL을 포함한 FreeBoardDTO 생성 메서드
	private FreeBoardDto createFreeBoardDTOWithImageUrl(PetFreeBoard freeBoard) {
    	FreeBoardDto dto = new FreeBoardDto(); // FreeBoardDTO 객체 생성
        dto.setFreeBoardId(freeBoard.getFreeBoardId()); // 게시글 ID 설정
        dto.setUserId(freeBoard.getUserId());
		dto.setNickname(freeBoard.getNickname());
		dto.setTitle(freeBoard.getTitle()); // 게시글 제목 설정
        dto.setContent(freeBoard.getContent()); // 게시글 내용 설정
        dto.setImageFile(freeBoard.getImagefile()); // 이미지 URL 생성 및 설정
		dto.setRegdate(freeBoard.getRegdate());
		dto.setUpdatedate(freeBoard.getUpdatedate());
		dto.setDeletedate(freeBoard.getDeletedate());
		dto.setViews(freeBoard.getViews());
		dto.setLikes(freeBoard.getLikes());

        return dto; // 이미지 URL이 포함된 DTO 반환
    }

	
	// 특정 게시글 조회(제목검색)
	public PetFreeBoard selectFreeBoard(int boardId) {
		
		// 1. 게시글이 있는 지 판단한다.
		if(petFreeBoardRepository.findByFreeBoardId(boardId) != null) {			
			// 1-1 제목 게시글 불러오고
			PetFreeBoard likeFreeBoard = petFreeBoardRepository.findByFreeBoardId(boardId);
			// 1-2 게시글 조회수 수정(증가)
			likeFreeBoard.setViews(likeFreeBoard.getViews() + 1); 		
			// 1-3 조회수 증가후 다시 저장
			petFreeBoardRepository.save(likeFreeBoard);
			
			// 2. 게시글 반환
			return petFreeBoardRepository.findByFreeBoardId(boardId);
		}else {
			return null;
		}
	}
	
	// 게시글 수정
	public Object updateFreeBoard(int freeBoardId, PetFreeBoard post, MultipartFile imageFile, String userId) {
		//Pet_member petMember = petMemberRepository.findByUserId(userId);
		
		// 해당 번호 게시글 가져오기
		PetFreeBoard petFreeBoard = petFreeBoardRepository.findByFreeBoardId(freeBoardId);

		// 본인 게시글이 맞는지 확인...
		if(!petFreeBoard.getUserId().equals(userId)) {
			return ResponseEntity.ok("본인 게시글이 아닙니다.");
		}else {
			PetFreeBoard modifyFreeBoard = petFreeBoardRepository.findByFreeBoardId(freeBoardId); // 번호로 게시글 찾고
			
			if(modifyFreeBoard != null) {
				modifyFreeBoard.setTitle(post.getTitle());
				modifyFreeBoard.setContent(post.getContent());
				modifyFreeBoard.setUpdatedate(new Date());
				
				if (imageFile != null && !imageFile.isEmpty()) {
				    try {
				        String imageFileName = saveImage(imageFile);
				        modifyFreeBoard.setImagefile(imageBaseURL + imageFileName); // 이미지 파일 이름 설정
				    } catch (IOException e) {
				        e.printStackTrace();
				    }
				}		
				return petFreeBoardRepository.save(modifyFreeBoard);
			}else {
				return null;
			}
		}
	}
	
	// 게시글 삭제
	@Transactional
	public ResponseEntity<String> deleteFreeBoard(int freeBoardId, String userId) {
		MemberEntity petMember = petMemberRepository.findByUserId(userId);

		if(petMember == null) {
			return ResponseEntity.ok("회원이 아닙니다.");
		}else {
			if(petFreeBoardRepository.findByFreeBoardId(freeBoardId) != null) {
				petFreeBoardRepository.deleteByFreeBoardId(freeBoardId);
			}
		}
		return ResponseEntity.ok("게시글이 삭제 되었습니다.");
	}
}
