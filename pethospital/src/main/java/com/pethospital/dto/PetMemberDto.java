package com.pethospital.dto;


import lombok.Data;

@Data
public class PetMemberDto {
	private String name;
	private String userId;
	private String password;
	private String nickname;
	private String email;
	private String mobilePhone;
	private String address;
}
