package com.crowd.funding.reward.domain;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.crowd.funding.member.model.MemberDTO;

@Repository
public class RewardDAOImpl implements RewardDAO {

	private static final String NAMESPACE = "com.crowd.funding.mapper.rewardMapper";
	
	private final SqlSession sqlSession;
	
	@Inject
	public RewardDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<RewardDTO> rewardAll(int pro_id) throws Exception {
		return sqlSession.selectList(NAMESPACE+".reward_all",pro_id);
	}
	
	@Override
	public List<RewardDTO> rewardSel(int reward_id[]) throws Exception {
		return sqlSession.selectList(NAMESPACE+".reward_select", reward_id);
	}

	@Override
	public MemberDTO personinfo(int mem_idx) throws Exception {
		return sqlSession.selectOne(NAMESPACE+".personinfo", mem_idx);
	}

	
}
