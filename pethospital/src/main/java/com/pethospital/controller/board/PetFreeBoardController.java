package com.pethospital.controller.board;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pethospital.domain.board.PetFreeBoard;
import com.pethospital.dto.FreeBoardDto;
import com.pethospital.service.board.PetFreeBoardService;

import jakarta.transaction.Transactional;

@RestController
public class PetFreeBoardController {

	@Autowired
	PetFreeBoardService petFreeBoardService;
	
	// 자유 게시판 - 회원
	// 게시글 등록 
	@PostMapping("/free")
	public ResponseEntity<String> createFree(@ModelAttribute PetFreeBoard petFreeBoard,
											 @RequestParam(name = "imageFile", required = false) MultipartFile imageFile,
											 Authentication authentication){
		
		if (authentication == null) {
	        return ResponseEntity.ok("회원이 아닙니다");
	    } else {
	    	// 멤버권한을 가진자만 게시글을 작성할 수 있다.
			String userId = authentication.getName();
			petFreeBoardService.createFreeService(petFreeBoard, imageFile,userId);
			return ResponseEntity.ok("글이 등록 되었습니다.");
	    }
	}
	
	// 전체 게시글 조회
	@GetMapping("/free")
	public ResponseEntity<List<FreeBoardDto>> allReadFree() {
		List<FreeBoardDto> boardsWithImageUrl = petFreeBoardService.allSelectFreeBoard();
		return ResponseEntity.ok(boardsWithImageUrl); 
	}
		
	// 특정 게시글 조회(번호검색)
	@GetMapping("/free/{boardId}")
	public PetFreeBoard readFree(@PathVariable int boardId){
		return petFreeBoardService.selectFreeBoard(boardId);
	}
		
	// 게시글 수정
	@PutMapping("free/{freeBoardId}")
	public Object updateFree(@PathVariable int freeBoardId, 
							 @ModelAttribute PetFreeBoard post,
							 @RequestParam(name = "imageFile", required = false) MultipartFile imageFile,
							 Authentication authentication) {
		
		String userId = authentication.getName();
		return petFreeBoardService.updateFreeBoard(freeBoardId, post, imageFile, userId);
	}
	
	// 게시글 삭제
	@Transactional
	@DeleteMapping("free/{freeBoardId}")
	public ResponseEntity<String> deleteFree(@PathVariable int freeBoardId, Authentication authentication) {
		String userId = authentication.getName();	
		return petFreeBoardService.deleteFreeBoard(freeBoardId, userId);
	}

	// 이미지 파일이 저장된 디렉토리 경로를 설정.
	private final String imageDirectory = "C:/MiniProject/pethospital/Image/Free";

	// 이미지 조회
	@GetMapping("/free/images/{imageName:.+}")
	public ResponseEntity<Resource> getImage(@PathVariable String imageName) throws MalformedURLException {

        // 요청된 이미지 파일 이름을 사용하여 이미지 파일의 경로를 가져오기.
        Path imagePath = Paths.get(imageDirectory).resolve(imageName);
        Resource imageResource = new UrlResource(imagePath.toUri());


        // 이미지 파일이 존재하지 않는 경우.
        if (!imageResource.exists()) {
            // 이미지가 없을 경우에 대한 처리를 여기에 작성.
            return ResponseEntity.notFound().build();
        }

        // 이미지 파일을 응답으로 반환합니다.
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(imageResource);
    }
			
}