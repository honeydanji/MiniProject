package com.pethospital.service;

import com.pethospital.componets.ObjectConversion;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.pethospital.domain.MemberEntity;
import com.pethospital.dto.PetMemberDto;
import com.pethospital.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository petMemberRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final ObjectConversion conversion;

    public String registerPetMember(PetMemberDto petMemberDto) throws Exception {
    	MemberEntity petMember = conversion.memberDtoToEntity(petMemberDto);
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
