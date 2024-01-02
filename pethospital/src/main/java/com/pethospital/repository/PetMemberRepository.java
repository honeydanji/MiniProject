package com.pethospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pethospital.domain.PetMember;

public interface PetMemberRepository extends JpaRepository<PetMember, Integer> {
	PetMember findByUserId(String userId);
}
