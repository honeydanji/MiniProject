package com.pethospital.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pethospital.domain.PetMember;
import com.pethospital.repository.PetMemberRepository;

@Service
@RequiredArgsConstructor
public class SecurityMemberService implements UserDetailsService {

	private final PetMemberRepository petMemberRepository;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		PetMember petMember = petMemberRepository.findByUserId(userId);

		if (petMember == null) {
			throw new UsernameNotFoundException(userId);
		}

		return new User(petMember.getUserId(), 
						petMember.getPassword(),
				true, true, true, true,
						petMember.getAuthorities());
	}

}
