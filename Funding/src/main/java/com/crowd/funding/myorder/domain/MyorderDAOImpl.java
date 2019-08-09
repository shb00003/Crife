package com.crowd.funding.myorder.domain;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.crowd.funding.member.model.MemberDTO;
import com.crowd.funding.myorder.common.MyorderDTOJoin;
import com.crowd.funding.order.domain.OrderDTO;
import com.crowd.funding.project.model.ProjectDTO;
import com.crowd.funding.reward.domain.RewardDTO;

@Repository
public class MyorderDAOImpl implements MyorderDAO {

	private static final String NAMESPACE = "com.crowd.funding.mapper.myorderMapper";
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<MyorderDTOJoin> orderList(int mem_idx) {
		return sqlSession.selectList(NAMESPACE+".my_order_list", mem_idx);
	}

	@Override
	public MyorderDTO orderInfo(int order_id) {
		return sqlSession.selectOne(NAMESPACE+".order_info", order_id);
	}

	@Override
	public OrderDTO shipInfo(int order_id) {
		return sqlSession.selectOne(NAMESPACE+".shipment_info", order_id);
	}

	@Override
	public MemberDTO memInfo(int order_id) {
		return sqlSession.selectOne(NAMESPACE+".mem_info", order_id);
	}

	@Override
	public ProjectDTO proInfo(int order_id) {
		return sqlSession.selectOne(NAMESPACE+".pro_info", order_id);
	}

	@Override
	public List<RewardDTO> rewardinfo(int order_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+".reward_info", order_id);
	}
	

}
