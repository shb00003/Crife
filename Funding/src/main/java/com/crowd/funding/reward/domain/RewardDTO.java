package com.crowd.funding.reward.domain;

import com.crowd.funding.myorder.domain.MyorderDTO;

public class RewardDTO {
	int reward_id; // order_reward_T의 키 값
	int pro_id; // project_T의 키 값
	int mem_idx; // member_T의 키값
	String reward_title;
	int reward_price;
	int reward_sell_count; // 리워드 판매가능한 갯수 
	int sumAmount; // 각 리워드별 합산 
	MyorderDTO myorderDTO;
	int remain_count; // 각 리워드 별 남은 수량
	int qty; // 사용자가 선택한 리워드별 수량
	String reward_description; // 리워드 상세설명
	String reward_option_detail; // 리워드 옵션
	
	
	public String getReward_description() {
		return reward_description;
	}

	public void setReward_description(String reward_description) {
		this.reward_description = reward_description;
	}

	public String getReward_option_detail() {
		return reward_option_detail;
	}

	public void setReward_option_detail(String reward_option_detail) {
		this.reward_option_detail = reward_option_detail;
	}

	public int getRemain_count() {
		return remain_count;
	}

	public void setRemain_count(int remain_count) {
		this.remain_count = remain_count;
	}

	public MyorderDTO getMyorderDTO() {
		return myorderDTO;
	}

	public void setMyorderDTO(MyorderDTO myorderDTO) {
		this.myorderDTO = myorderDTO;
	}

	public int getReward_id() {
		return reward_id;
	}

	public void setReward_id(int reward_id) {
		this.reward_id = reward_id;
	}

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	public int getMem_idx() {
		return mem_idx;
	}

	public void setMem_idx(int mem_idx) {
		this.mem_idx = mem_idx;
	}

	public String getReward_title() {
		return reward_title;
	}

	public void setReward_title(String reward_title) {
		this.reward_title = reward_title;
	}

	public int getReward_price() {
		return reward_price;
	}

	public void setReward_price(int reward_price) {
		this.reward_price = reward_price;
	}

	public int getReward_sell_count() {
		return reward_sell_count;
	}

	public void setReward_sell_count(int reward_sell_count) {
		this.reward_sell_count = reward_sell_count;
	}

	public int getSumAmount() {
		return sumAmount;
	}

	public void setSumAmount(int sumAmount) {
		this.sumAmount = sumAmount;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	

}
