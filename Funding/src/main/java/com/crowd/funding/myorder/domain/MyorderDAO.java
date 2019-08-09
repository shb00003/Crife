package com.crowd.funding.myorder.domain;

import java.util.List;

import com.crowd.funding.member.model.MemberDTO;
import com.crowd.funding.myorder.common.MyorderDTOJoin;
import com.crowd.funding.order.domain.OrderDTO;
import com.crowd.funding.project.model.ProjectDTO;
import com.crowd.funding.reward.domain.RewardDTO;

public interface MyorderDAO {
	 public List<MyorderDTOJoin> orderList(int mem_idx);
	// public List<MyorderDTOJoin> orderDetail(MyorderDTOJoin myorderJoin);
	 public MyorderDTO orderInfo(int order_id);
	 public OrderDTO shipInfo(int order_id);
	 public MemberDTO memInfo(int order_id);
	 public ProjectDTO proInfo(int order_id);
	 public List<RewardDTO> rewardinfo(int order_id);
}
