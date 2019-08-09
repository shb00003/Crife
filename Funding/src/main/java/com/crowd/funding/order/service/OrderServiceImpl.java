package com.crowd.funding.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.crowd.funding.myorder.domain.MyorderDTO;
import com.crowd.funding.order.domain.OrderDAO;
import com.crowd.funding.order.domain.OrderDTO;

@Service
public class OrderServiceImpl implements OrderService {

	@Inject
	OrderDAO orderDAO;

	@Override
	public void insert(OrderDTO orderDTO) throws Exception {
		orderDAO.insert(orderDTO);
	}

	@Override
	public void myOrderInsert(ArrayList<MyorderDTO> myorderDTO) throws Exception {
		orderDAO.myOrderInsert(myorderDTO);
	}

	@Override
	public OrderDTO orderInfo(int mem_idx) throws Exception {
		return orderDAO.orderInfo(mem_idx);
	}
	
	
}
