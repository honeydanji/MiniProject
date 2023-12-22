package com.pethospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pethospital.domain.PetMember;

public interface PetMemberRepository extends JpaRepository<PetMember, Integer> {
    // 프론트에서 전송한 회원가입 정보를 Pet_member 저장.
	
	PetMember findByUserId(String userId);
}
