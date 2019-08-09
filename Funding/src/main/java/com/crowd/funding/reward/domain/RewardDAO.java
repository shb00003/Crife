package com.crowd.funding.reward.domain;

import java.util.List;
import java.util.Map;

import com.crowd.funding.member.model.MemberDTO;

public interface RewardDAO {
	List<RewardDTO> rewardAll (int pro_id) throws Exception;
	List<RewardDTO> rewardSel (int reward_id[]) throws Exception;
	MemberDTO personinfo(int mem_idx) throws Exception;
}
