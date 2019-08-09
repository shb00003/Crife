package com.crowd.funding.member.model;

import lombok.Data;

@Data
public class LoginDTO {

	// 로그인 view의 정보
	private String mem_email;
	private String mem_password;
	private boolean useCookie;

	
}
