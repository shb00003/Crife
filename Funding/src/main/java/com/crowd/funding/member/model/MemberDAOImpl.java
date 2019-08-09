package com.crowd.funding.member.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	SqlSession sql;

	@Override
	public void snsjoinPOST(MemberDTO memDTO) throws Exception {
		System.out.println("##### memberDAO : snsjoinPOST #####");
		sql.insert("member.snsjoin", memDTO);
	}

	@Override
	public MemberDTO snsLogin(MemberDTO mem) throws Exception {
		System.out.println("+++++++++++++++ snsLogin +++++++++++++++++");
		return sql.selectOne("member.snsLogin", mem.getNaver_idx());
	}

	@Override
	public void joinPOST(MemberDTO memDTO) throws Exception {
		System.out.println("##### memberDAO : joinPOST #####");

		sql.insert("member.join", memDTO);
	}

	@Override
	public MemberDTO loginPOST(LoginDTO logDTO) throws Exception {
		System.out.println("##### memberDAO : loginPOST #####");
		return sql.selectOne("member.login", logDTO);
	}

	@Override
	public void creatKey(String mem_email, String email_key) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mem_email", mem_email);
		map.put("email_key", email_key);

		sql.selectOne("member.join_email", map);
	}

	@Override
	public void emailAuth(String mem_email, String email_key) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mem_email", mem_email);
		map.put("email_key", email_key);

		sql.update("member.auth_email", map);
		sql.update("member.keyTOexpired", mem_email);
	}

	@Override
	public int chkKey(String mem_email, int email_type) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("mem_email", mem_email);
		map.put("email_type", email_type);
		return sql.selectOne("member.chkexpired", map);
	}

	@Override
	public void lastLogin(String mem_email, Date lastLogin) throws Exception {
		System.out.println("##### memberDAO : lastLogin #####");

		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("mem_email", mem_email);
		paramMap.put("lastLogin", lastLogin);

		sql.update("member.lastLogin", paramMap);
	}

	@Override
	public void keepLogin(String mem_email, String sessionid, Date sessionlimit) throws Exception {
		System.out.println("##### memberDAO : keepLogin #####");

		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("mem_email", mem_email);
		paramMap.put("sessionid", sessionid);
		paramMap.put("sessionlimit", sessionlimit);

		sql.update("member.keepLogin", paramMap);
	}

	@Override
	public MemberDTO checkSessionKey(String value) throws Exception {
		System.out.println("##### memberDAO : checkSessionKey #####");
		return sql.selectOne("member.checkSessionKey", value);
	}

	@Override
	public MemberDTO myinfo(int mem_idx) throws Exception {
		System.out.println("##### memberDAO : myinfo #####");
		return sql.selectOne("member.myinfo", mem_idx);
	}

	@Override
	public void myinfoUP(MemberDTO memDTO) throws Exception {
		System.out.println("##### memberDAO : myinfoUP #####");
		sql.selectOne("member.myinfo_up", memDTO);
	}

	@Override
	public void myinfoDEL(int mem_idx) throws Exception {
		System.out.println("##### memberDAO : myinfoDEL #####");
		sql.update("member.myinfo_del", mem_idx);
	}

	@Override
	public int userfindID(String find) throws Exception {
		System.out.println("##### memberDAO : userfindID #####");
		return sql.selectOne("member.userfindID", find);
	}

	@Override
	public void userfindPW(String find, String email_key) throws Exception {
		System.out.println("##### memberDAO : resetPW #####");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("find", find);
		map.put("email_key", email_key);
		sql.insert("member.emailpw", map);
	}

	@Override
	public void resetPW(String mem_password, String mem_email, String email_key) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mem_email", mem_email);
		map.put("email_key", email_key);
		map.put("mem_password", mem_password);

		sql.update("member.resetPW", map);
		sql.update("member.keyTOexpired", mem_email);
	}

}
