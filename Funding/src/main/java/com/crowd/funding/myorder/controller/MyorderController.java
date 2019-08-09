package com.crowd.funding.myorder.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crowd.funding.myorder.service.MyorderService;

@Controller
@RequestMapping("/mypage")
public class MyorderController {

	@Inject
	MyorderService myorderService;
	
	@RequestMapping("/myorder/orderlist")
	// mem_idx 받아야함.
	public String myRewardList(Model model, @RequestParam("pro_id") int pro_id) {
		model.addAttribute("rewardList", myorderService.orderList(2));
		return "/myorder/orderlist";
	}
	@RequestMapping("/myorder/orderdetail")
	public String myOrderList(Model model, @RequestParam("order_id") int order_id) {
		model.addAttribute("orderinfo", myorderService.orderInfo(order_id));
		model.addAttribute("proinfo", myorderService.proInfo(order_id));
		model.addAttribute("meminfo", myorderService.memInfo(order_id));
		model.addAttribute("shipinfo", myorderService.shipInfo(order_id));
		model.addAttribute("rewardinfo", myorderService.rewardinfo(order_id));
		return "/myorder/orderdetail";
	}
	
	/*
	 * @RequestMapping("/myreward/fundinglist") // mem_idx 받아야함. public String
	 * payment(Model model, @RequestParam("pro_id") int pro_id) {
	 * model.addAttribute("rewardList", myorderService.rewardList(pro_id)); return
	 * "/myorder/myreward"; }
	 */
	
	@RequestMapping("/myprofile/fundinglist")
	public void myFundingList() {
		
	}
}
