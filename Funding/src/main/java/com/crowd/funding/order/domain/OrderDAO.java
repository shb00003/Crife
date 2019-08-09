package com.crowd.funding.order.domain;

import java.util.ArrayList;

import com.crowd.funding.myorder.domain.MyorderDTO;

public interface OrderDAO {
	
	public void insert(OrderDTO orderDTO) throws Exception; 
	public void myOrderInsert(ArrayList<MyorderDTO> myorderDTO) throws Exception;
	public OrderDTO orderInfo(int mem_idx) throws Exception;
}
