package com.crowd.funding.member.model;

import java.util.Date;

public interface MemberDAO {

	// sns
	MemberDTO snsLogin(MemberDTO mem) throws Exception;
	void snsjoinPOST(MemberDTO memDTO) throws Exception;
	void joinPOST(MemberDTO memDTO) throws Exception;
	MemberDTO loginPOST(LoginDTO logDTO) throws Exception;
	// 이메일 인증키 db에 저장
	void creatKey(String mem_email, String email_key) throws Exception;
	// 인증 완료 - mem_email_cert=1 로 update
	void emailAuth(String mem_email, String email_key) throws Exception;
	int chkKey(String mem_email, int email_type) throws Exception;
	// 마지막 로그인 시간 저장
	void lastLogin(String mem_email, Date lastLogin) throws Exception;
	// 로그인 유지 처리
	void keepLogin(String mem_email, String sessionid, Date sessionlimit) throws Exception;
	// 세션키 검증
	MemberDTO checkSessionKey(String value) throws Exception;
	// 내정보
	MemberDTO myinfo(int mem_idx) throws Exception;
	// 내정보 - 수정
	void myinfoUP(MemberDTO memDTO) throws Exception;
	// 내정보 - 삭제(탈퇴요청)
	void myinfoDEL(int mem_idx) throws Exception;
	// 아이디 찾기
	int userfindID(String find) throws Exception;
	// 비밀번호 재설정 이메일 발송
	void userfindPW(String find, String email_key) throws Exception;
	// 비밀번호 재설정
	void resetPW(String mem_password, String mem_email, String email_key) throws Exception;

}
