package com.pethospital.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pethospital.dto.MemberDto;
import com.pethospital.service.SecurityMemberService;
import com.pethospital.vo.LoginRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@Slf4j
@RequiredArgsConstructor
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final SecurityMemberService securityMember;
    private final Environment environment;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        try {
            LoginRequest login = new ObjectMapper().readValue(request.getInputStream(), LoginRequest.class);
            log.info(login.getUserId());
            log.info(login.getPassword());

            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            login.getUserId(),
                            login.getPassword(),
                            new ArrayList<>()
                    )
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
//        super.successfulAuthentication(request, response, chain, authResult);
        log.info("성공");
        String userId = ((User)authResult.getPrincipal()).getUsername();
        MemberDto memberDto = securityMember.getUserDetailsByUserId(userId);

        String token = Jwts.builder()
                .setSubject(memberDto.getUserId())
                .setExpiration(new Date(System.currentTimeMillis() +
                        Long.parseLong(environment.getProperty("token.expiration_time"))))
                .signWith(SignatureAlgorithm.HS256, environment.getProperty("token.secret"))
                .compact();

        response.addHeader("token", token);
        response.addHeader("userId", memberDto.getUserId());

        log.info(token);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,
                                              HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {
//        super.unsuccessfulAuthentication(request, response, failed);
        log.info(failed.getMessage());
        log.info("실패");
    }
}
