package com.pethospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pethospital.domain.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {
	MemberEntity findByUserId(String userId);
}
