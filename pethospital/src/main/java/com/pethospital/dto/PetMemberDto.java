package com.pethospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetMemberDto {
	
	private String name;
	private String userId;
	private String password;
	private String nickname;
	private String email;
	private String mobilePhone;
	private String address;
//	private String role;
}
