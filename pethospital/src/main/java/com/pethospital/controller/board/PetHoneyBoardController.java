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

import com.pethospital.domain.board.PetHoneyBoard;
import com.pethospital.service.board.PetHoneyBoardService;

import jakarta.transaction.Transactional;

@RestController
public class PetHoneyBoardController {
	
	@Autowired
	PetHoneyBoardService petHoneyBoardService;
	
	// 꿀팁 게시판
	// 게시글 등록하기
	@PostMapping("/honey")
	public ResponseEntity<String> createBoard(@ModelAttribute PetHoneyBoard petHoneyBoard,
											  @RequestParam(name = "imageFile", required = false) MultipartFile imageFile,
											  Authentication authentication){	
		if (authentication == null) {
			return ResponseEntity.ok("회원이 아닙니다.");
		}else {
			// 권한이 있어야 게시글 작성가능
			String userId = authentication.getName();
			petHoneyBoardService.createHoneyService(petHoneyBoard, imageFile, userId);
			return ResponseEntity.ok("글이 등록 되었습니다.");
		}
	}
	
	// 전체 게시글 가져오기
	@GetMapping("/honey")
	public List<PetHoneyBoard> allReadBoard(){
		return petHoneyBoardService.allSelectHoneyBoard();
	}
	
	// 특정 게시글 가져오기(게시글 번호)
	@GetMapping("/honey/{boardId}")
	public PetHoneyBoard readBoard(@PathVariable int boardId){
		return petHoneyBoardService.selectHoneyBoard(boardId);
	}
	
	// 게시글 수정하기
	@PutMapping("/honey/{honeyBoardId}")
	public Object updateBoard(@PathVariable int honeyBoardId, 
							  @ModelAttribute PetHoneyBoard post,
							  @RequestParam(name = "imageFile", required = false) MultipartFile imageFile,
							  Authentication authentication) {
		String userId = authentication.getName();
		return petHoneyBoardService.updateHoneyBoard(honeyBoardId, post, imageFile, userId);
	}
	
	// 게시글 삭제하기
	@Transactional
	@DeleteMapping("/honey/{honeyBoardId}")
	public ResponseEntity<String> deleteBoard(@PathVariable int honeyBoardId, Authentication authentication) {
		String userId = authentication.getName();
		
		return petHoneyBoardService.deleteHoneyBoard(honeyBoardId, userId);
	}

	// 이미지 파일이 저장된 디렉토리 경로를 설정.
	private final String imageDirectory = "C:/MiniProject/pethospital/Image/Honey";

	// 이미지 조회
	@GetMapping("/honey/images/{imageName:.+}")
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