package com.crowd.funding.admin.ad_member;

import java.util.List;

import com.crowd.funding.member.model.MemberDTO;

public interface Ad_MemberDAO {
	public List<MemberDTO> memberList();
	public MemberDTO memberDetail(int mem_idx);
	public void memberUpdate(MemberDTO dto) ;

}
