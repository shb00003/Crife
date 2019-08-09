package com.crowd.funding.admin.ad_member;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.crowd.funding.member.model.MemberDTO;


@Repository
public class Ad_MemberDAOImpl implements Ad_MemberDAO {

	@Inject
	SqlSession sqlSession;

	@Override
	public List<MemberDTO> memberList() {
		return sqlSession.selectList("admin.mem_list");
	}

	@Override
	public MemberDTO memberDetail(int mem_idx) {
		return sqlSession.selectOne("member.mem_detail", mem_idx);
	}

	@Override
	public void memberUpdate(MemberDTO dto) {
		sqlSession.update("member.mem_update", dto);

	}

}