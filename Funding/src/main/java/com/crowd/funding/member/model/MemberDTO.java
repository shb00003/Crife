package com.crowd.funding.member.model;

import java.util.Date;

import lombok.Data;

@Data
public class MemberDTO {

	// 회원가입시 받을 최소 정보
	private int mem_idx;
	private int mem_type;
	private String mem_email;
	private String mem_password;
	private String mem_name;
	private String mem_phone;
	private int mem_birth;
	private int mem_sex;

	private int mem_email_cert;
	private Date mem_register_datetime;
	private Date mem_lastlogin_datetime;

	//
	private int mem_zipcode;
	private String mem_address1;
	private String mem_address2;
	private String mem_address3;
	private String mem_address4;
	private String mem_photo; // 기본이미지 default로 추가해주기

	private String naver_idx;

}
