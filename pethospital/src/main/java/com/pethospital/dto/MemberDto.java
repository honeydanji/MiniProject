package com.pethospital.dto;

import lombok.Data;

@Data
public class MemberDto {
	private String name;
	private String nickname;
	private String userId;
	private String password;
	private String email;
	private String mobilePhone;
	private String address;
}
