package com.crowd.funding.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.crowd.funding.myorder.domain.MyorderDTO;
import com.crowd.funding.order.domain.OrderDTO;

public interface OrderService {
	public void insert(OrderDTO orderDTO) throws Exception; 
	public void myOrderInsert(ArrayList<MyorderDTO> myorderDTO) throws Exception;
	public OrderDTO orderInfo(int mem_idx) throws Exception;
}
