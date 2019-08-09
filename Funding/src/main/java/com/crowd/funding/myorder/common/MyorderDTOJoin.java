package com.crowd.funding.myorder.common;

import com.crowd.funding.myorder.domain.MyorderDTO;

public class MyorderDTOJoin extends MyorderDTO {
	
	private String project_name;
	private String reward_title;
	private int reward_price;
	private String order_name;
	private String mem_email;
	private String order_requests;
	private String order_addressAll;
	private String pro_name;
	private String pro_category;
	private String mem_name;
	
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getPro_category() {
		return pro_category;
	}
	public void setPro_category(String pro_category) {
		this.pro_category = pro_category;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
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
	public String getOrder_name() {
		return order_name;
	}
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public String getOrder_requests() {
		return order_requests;
	}
	public void setOrder_requests(String order_requests) {
		this.order_requests = order_requests;
	}
	public String getOrder_addressAll() {
		return order_addressAll;
	}
	public void setOrder_addressAll(String order_addressAll) {
		this.order_addressAll = order_addressAll;
	}
}
