package com.crowd.funding.admin.ad_member;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.crowd.funding.member.model.MemberDTO;

@Service
public class Ad_MemServiceImpl implements Ad_MemService {

	@Inject
	Ad_MemberDAO ad_memberDao;
	
	@Override
	public List<MemberDTO> memberList() {
		return ad_memberDao.memberList();
	}

	@Override
	public MemberDTO memberDetail(int mem_idx) {
		return ad_memberDao.memberDetail(mem_idx);
	}

	@Override
	public void memberUpdate(MemberDTO dto) {
		ad_memberDao.memberUpdate(dto);

	}

}
