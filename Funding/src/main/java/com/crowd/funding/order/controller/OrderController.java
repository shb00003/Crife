package com.crowd.funding.order.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crowd.funding.myorder.domain.MyorderDTO;
import com.crowd.funding.order.domain.OrderDTO;
import com.crowd.funding.order.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Inject
	OrderService orderService;
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@RequestMapping(value="/reservation", method = RequestMethod.POST)

	public String orderInsert(Model model, OrderDTO orderDTO, MyorderDTO myorderDTO, RedirectAttributes redirectAttributes) throws Exception {
		System.out.println("reservation 동작체크");
		orderService.insert(orderDTO);
		int orderId = orderDTO.getOrder_id();
		/*
		 * System.out.println("myoderDATA"+myoderDATA.getList());
		 * System.out.println("myorderDTO"+myorderDTO.getList());
		 * System.out.println("orderId"+orderId);
		 */
		for(int i = 0 ; i < myorderDTO.getOrderList().size(); i++) {
			myorderDTO.getOrderList().get(i).setOrder_id(orderId);
			/*
			 * myorderDTO.getOrderList().get(i).setOrder_id(orderId);
			 * myorderDTO.getOrderList().get(i).setOrder_id(orderId);
			 */
		}
		orderService.myOrderInsert(myorderDTO.getOrderList());
		
		return "redirect:/order/orderbill";
	}
	
	@RequestMapping(value="/orderbill", method = RequestMethod.GET)
	public String orderBill(Model model) throws Exception {

		return "/order/orderbill";	
	}
	
	
	
	// 받을 수 없기 때문에 생각을 해보자
	//public String test(List<MyorderDTO> orderList) throws Exception {
	@RequestMapping(value="/ordertest2", method=RequestMethod.POST)
	public String test(MyorderDTO myorderDTO) throws Exception {

		//System.out.println(myorderDTO.toString());
		//첫번째 객체
		//System.out.println(myorderDTO.getOrderList().get(0));
		// 두번째 객체
		//System.out.println(myorderDTO.getOrderList().get(1));
		
		//myorderDTO.getOrderList().get(3).setOrder_id(2);
		for(int i = 0 ; i < myorderDTO.getOrderList().size(); i++) {
			myorderDTO.getOrderList().get(i).setOrder_id(2);
		}
		orderService.myOrderInsert(myorderDTO.getOrderList());
		return "order/ordertest2";
	}
	

}
