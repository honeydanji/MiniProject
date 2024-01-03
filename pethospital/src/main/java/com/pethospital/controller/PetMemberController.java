package com.pethospital.controller;

import com.pethospital.componets.ObjectConversion;
import com.pethospital.vo.PetMemberRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pethospital.service.PetMemberService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-service")
public class PetMemberController {

    private final PetMemberService petMemberService;
    private final ObjectConversion conversion;

    @PostMapping("/register")
    public ResponseEntity<String> registerMember(@Valid @RequestBody PetMemberRequest petMemberRequest) {

        petMemberService.registerPetMember(conversion.memberRequestToDto(petMemberRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입을 축하드립니다.");
    }
}
