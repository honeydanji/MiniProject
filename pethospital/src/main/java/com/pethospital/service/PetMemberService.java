package com.pethospital.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
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

    public void registerPetMember(PetMemberDto petMemberDto) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

    	PetMember petMember = mapper.map(petMemberDto, PetMember.class);
		petMember.setPassword(bCryptPasswordEncoder.encode(petMemberDto.getPassword()));
    	petMember.setRole("ROLE_MEMBER");

		petMemberRepository.save(petMember);
    }
}
