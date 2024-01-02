package com.pethospital.service;

import com.pethospital.componets.ObjectConversion;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.pethospital.domain.PetMember;
import com.pethospital.dto.PetMemberDto;
import com.pethospital.repository.PetMemberRepository;

@Service
@RequiredArgsConstructor
public class PetMemberService {

	private final PetMemberRepository petMemberRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final ObjectConversion conversion;

    public void registerPetMember(PetMemberDto petMemberDto) {
    	PetMember petMember = conversion.memberDtoToEntity(petMemberDto);
		petMember.setPassword(bCryptPasswordEncoder.encode(petMemberDto.getPassword()));
    	petMember.setRole("ROLE_MEMBER");

		petMemberRepository.save(petMember);
    }
}
