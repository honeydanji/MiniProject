package com.pethospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pethospital.dto.PetMemberDto;
import com.pethospital.service.PetMemberService;

@RestController
public class PetMemberController {

    private final PetMemberService petMemberService;

    @Autowired
    public PetMemberController(PetMemberService petMemberService) {
        this.petMemberService = petMemberService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerMember(@RequestBody PetMemberDto petMemberDto) {
        petMemberService.registerPetMember(petMemberDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입을 축하드립니다.");
    }
    
//    // 로그인
//    @PostMapping("/login")
//    public Authentication loginMember(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//        // attemptAuthentication 메서드 호출로 인증 시도 및 결과를 받아옴
//    	return jwt.attemptAuthentication(req, resp); // JWT 토큰을 응답 본문에 포함하여 반환
//    }

//    	// 1. 아이디와 비밀번호 토큰 생성.
//    	UsernamePasswordAuthenticationToken tok = new UsernamePasswordAuthenticationToken(petMember.getUserId(), petMember.getPassword());
//    	
//    	// 2. 인증성공하면 사용자 정보 객체 반환
//    	AuthenticationManager man = authConfig.getAuthenticationManager();
//    	
//    	// 3. 인증시도
//    	Authentication auth = man.authenticate(tok);
//    	
//    	// 4. 인증 성공 후 User 정보 가져오기
//    	User user = (User)auth.getPrincipal();
//		
//		// JWT 생성
//		String jwtToken = JWT.create()
//							.withClaim("username", user.getUsername()) // 토큰에 저장되는 정보(선택사항)
//							.withExpiresAt(new Date(System.currentTimeMillis()+1000*60*10)) // 토큰 유지시간
//							.sign(Algorithm.HMAC256("edu.pnu.jwtkey")); // 암호화
//		
//		// 응답 Header에 "Authorization"이라는 키를 추가해서 JWT를 설정
//		// Bearer : JWT토큰임을 나타내는 용어; Basic : "Basic "+Base64(username:password)
//		 HttpHeaders header = new HttpHeaders();
//		 header.add("Authorization", "Bearer " + jwtToken);
//		    
//		 // JWT 토큰을 응답으로 반환
//		 return ResponseEntity.ok().headers(header).build();    
}
