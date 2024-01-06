package com.pethospital.service;

import com.pethospital.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pethospital.domain.MemberEntity;
import com.pethospital.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class SecurityMemberService implements UserDetailsService {

	private final MemberRepository petMemberRepository;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		MemberEntity petMember = petMemberRepository.findByUserId(userId);

		if (petMember == null) {
			throw new UsernameNotFoundException(userId);
		}

		return new User(petMember.getUserId(), 
						petMember.getPassword(),
				true, true, true, true,
						petMember.getAuthorities());
	}

	public MemberDto getUserDetailsByUserId(String userId) {
		MemberEntity memberEntity = petMemberRepository.findByUserId(userId);

		if (memberEntity == null) {
			throw new UsernameNotFoundException(userId);
		}

		MemberDto memberDto = new ModelMapper().map(memberEntity, MemberDto.class);
		return memberDto;
	}
}
