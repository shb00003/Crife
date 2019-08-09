package com.crowd.funding.order.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.crowd.funding.myorder.domain.MyorderDTO;

@Repository
public class OrderDAOImpl implements OrderDAO {

	private static final String NAMESPACE = "com.crowd.funding.mapper.orderMapper";
		
	private final SqlSession sqlSession;
		
	@Inject
	public OrderDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void insert(OrderDTO orderDTO) throws Exception {
		sqlSession.insert(NAMESPACE + ".order_insert",orderDTO);	
	}

	@Override
	public void myOrderInsert(ArrayList<MyorderDTO> myorderDTO) throws Exception {
		sqlSession.insert(NAMESPACE + ".my_order_insert",myorderDTO);	
	}

	@Override
	public OrderDTO orderInfo(int mem_idx) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".order_info", mem_idx);
	}
	
}
