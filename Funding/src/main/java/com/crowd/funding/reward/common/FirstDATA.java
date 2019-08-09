package com.crowd.funding.reward.common;

import java.util.ArrayList;
import java.util.List;

import com.crowd.funding.reward.domain.RewardDTO;

public class FirstDATA {
	int addDonation;
	private ArrayList<RewardDTO> list;
	
	public ArrayList<RewardDTO> getList() {
		return list;
	}

	public void setList(ArrayList<RewardDTO> list) {
		this.list = list;
	}

	public int getAddDonation() {
		return addDonation;
	}

	public void setAddDonation(int addDonation) {
		this.addDonation = addDonation;
	}
	

}
