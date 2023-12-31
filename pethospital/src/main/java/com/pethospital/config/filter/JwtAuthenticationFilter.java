package com.pethospital.config.filter;

import java.io.IOException;
import java.util.Date;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pethospital.domain.PetMember;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j // : 디버그, 오류, 정보 등에 관한 메시지를 설정할 수 있다. 특정 오류에 대한 해답을 오류 메시지로 기록할 수 있다.(잘 쓰면 정말 유용)
@RequiredArgsConstructor // : 클래스 내에 모든 필드에 대한 생성자를 자동으로 생성해준다.
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	private final AuthenticationManager authenticationManager;

	// 1번 => 토큰이 없는 경우는 여기로 
	@Override 
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse resp) throws AuthenticationException {
		// req : Pet_member 객체 받고
		// resp : 생성된 토큰 반환
		
		try {
			ObjectMapper om = new ObjectMapper(); // JSON 데이터를 역질렬화 즉 데이터구조를 바꿔준다.
			PetMember petMember = om.readValue(req.getInputStream(), PetMember.class);
			// req.getInputStream() : JSON형태를 읽는다.
			// Pet_member.class : 읽은 데이터를 Pet_member개체로 역직렬화한다.(역직렬화 : JSON데이터의 구조를 변환시킨다. 왜? 그래야 자바에서 알아먹는다.)
			
			log.info("아이디 확인 : " + petMember.getUserId());
			//log.info("비밀번호 확인 : " + password);
			
			Authentication authToken = new UsernamePasswordAuthenticationToken(petMember.getUserId(), petMember.getPassword()); 
			// get으로 userId와 password를 저장한 사용자 인증 토큰 생성(변수이름은 마음대로)
			log.info("토큰 확인 : " + authToken);
			
			Authentication auth = authenticationManager.authenticate(authToken); // authenticate : SecurityUserDetailsService를 불러온다....
			// 위에서 만들어진 토큰이 유효한가?
			log.info("222토큰 확인 : " + auth);
			
			log.info("attemptAuthentication :[" + petMember.getUserId() + "]"); 
			return auth; // 클라이언트로 생성된 토큰을 반환한다.
		} catch (Exception e) {
			log.info("Not Authenticated : " + e.getMessage());
			return null;
		}	
	}
	
	// 2번 => 위 코드에서 토큰 만들고 여기로
	@Override 
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse resp, FilterChain chain, Authentication authResult) throws IOException, ServletException {
		
		User user = (User)authResult.getPrincipal();
		log.info("successfulAuthentication:" + user.toString());
		
		// JWT 생성
		String jwtToken = JWT.create()
							.withClaim("userId", user.getUsername()) // 토큰에 저장되는 정보(선택사항)
							.withExpiresAt(new Date(System.currentTimeMillis()+1000*600*10)) // 토큰 유지시간
							.sign(Algorithm.HMAC256("edu.pnu.jwtkey")); // 암호화
		// 응답 Header에 "Authorization"이라는 키를 추가해서 JWT를 설정
		// Bearer : JWT토큰임을 나타내는 용어; Basic : "Basic "+Base64(username:password)
		
		log.info("jwtToken : " + jwtToken);
		
		// 클라이언트로 전송할 메시지 설정
	    String message = "good";
		
		resp.addHeader("Authorization", "Bearer " + jwtToken);
		
		// 클라이언트로 메시지를 보내기 위해 응답 코드와 메시지 설정
	    resp.setStatus(HttpServletResponse.SC_OK); // 200 OK
	    resp.getWriter().write(message);
	    resp.getWriter().flush();
	    resp.getWriter().close();
		
		log.info("resp : " + resp.getHeaderNames());
		//chain.doFilter(req, resp);
	}
}
