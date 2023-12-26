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
}
