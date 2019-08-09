package com.crowd.funding.reward.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.crowd.funding.member.model.MemberDTO;
import com.crowd.funding.reward.domain.RewardDAO;
import com.crowd.funding.reward.domain.RewardDTO;

@Service
public class RewardServiceImpl implements RewardService {

	@Inject
	RewardDAO rewardDAO;
	
	// 생성자에서 Inject 하는 것과 변수로 Inject 하는 차이점이 무엇일까.

	@Override
	public List<RewardDTO> rewardAll(int pro_id) throws Exception {
		return rewardDAO.rewardAll(pro_id);
	}

	@Override
	public List<RewardDTO> rewardSel(int reward_id[]) throws Exception {
		return rewardDAO.rewardSel(reward_id);
	}

	@Override
	public MemberDTO personinfo(int mem_idx) throws Exception {
		// TODO Auto-generated method stub
		return rewardDAO.personinfo(mem_idx);
	}
}
