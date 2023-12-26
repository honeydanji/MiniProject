package com.pethospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.pethospital.domain.PetMember;
import com.pethospital.dto.PetMemberDto;
import com.pethospital.repository.PetMemberRepository;

@Service
public class PetMemberService {
	private final PetMemberRepository petMemberRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public PetMemberService(PetMemberRepository petMemberRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.petMemberRepository = petMemberRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

    // 회원 정보 저장
    public void registerPetMember(PetMemberDto petMemberDto) {
    	PetMember petMember = new PetMember();
    	
    	// 필수사항
    	petMember.setName(petMemberDto.getName());
    	petMember.setUserId(petMemberDto.getUserId());
    	petMember.setPassword(bCryptPasswordEncoder.encode(petMemberDto.getPassword())); // 암호화하기
    	petMember.setNickname(petMemberDto.getNickname());
    	petMember.setEmail(petMemberDto.getEmail());
    	
     	// 선택사항
    	petMember.setMobilePhone(petMemberDto.getMobilePhone());
    	petMember.setAddress(petMemberDto.getAddress()); 
    	
    	// 권한부여
    	petMember.setRole("ROLE_MEMBER");

		petMemberRepository.save(petMember);
    }
}
