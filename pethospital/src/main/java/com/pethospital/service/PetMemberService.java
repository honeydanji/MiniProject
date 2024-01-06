package com.pethospital.service;

import com.pethospital.componets.ObjectConversion;
import jakarta.validation.ConstraintViolationException;
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

    public String registerPetMember(PetMemberDto petMemberDto) throws Exception {
    	PetMember petMember = conversion.memberDtoToEntity(petMemberDto);
		petMember.setPassword(bCryptPasswordEncoder.encode(petMemberDto.getPassword()));
    	petMember.setRole("ROLE_MEMBER");

		try {
			petMemberRepository.save(petMember);
			return null;
		} catch (Exception e) {
			throw new Exception(e);
		}
    }
}
