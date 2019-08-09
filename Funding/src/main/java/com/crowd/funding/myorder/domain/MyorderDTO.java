package com.crowd.funding.myorder.domain;

import java.util.ArrayList;

import com.crowd.funding.member.model.MemberDTO;
import com.crowd.funding.order.domain.OrderDTO;
import com.crowd.funding.project.model.ProjectDTO;
import com.crowd.funding.reward.domain.RewardDTO;

public class MyorderDTO {
	 int myinfo;  // myoder_T primary key
	 int mem_idx; // member_T primary key
	 int pro_id; // project_T primary key
	 int reward_id; // reward_item_T primary key
	 int order_count; // 리워드 구매 갯수
     int order_id; // reward_order_T primary key
     String order_date; // 주문한 날짜
	 private ArrayList<MyorderDTO> orderList;

	 
	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public ArrayList<MyorderDTO> getOrderList() {
		return orderList;
	}
	
	public void setOrderList(ArrayList<MyorderDTO> orderList) {
		this.orderList = orderList;
	}

	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}
	
	 public int getMyinfo() {
		return myinfo;
	}
	public void setMyinfo(int myinfo) {
		this.myinfo = myinfo;
	}
	public int getMem_idx() {
		return mem_idx;
	}
	public void setMem_idx(int mem_idx) {
		this.mem_idx = mem_idx;
	}
	public int getPro_id() {
		return pro_id;
	}
	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}
	public int getReward_id() {
		return reward_id;
	}
	public void setReward_id(int reward_id) {
		this.reward_id = reward_id;
	}

	public int getOrder_count() {
		return order_count;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	@Override
	public String toString() {
		return "MyorderDTO [myinfo=" + myinfo + ", mem_idx=" + mem_idx + ", pro_id=" + pro_id + ", reward_id="
				+ reward_id + ", order_count=" + order_count + ", order_id=" + order_id + ", orderList=" + orderList
				+ "]";
	}
	
}
