package com.crowd.funding.admin.ad_member;

import java.util.List;

import com.crowd.funding.member.model.MemberDTO;

public interface Ad_MemService {
	
	public List<MemberDTO> memList
	       (String memSearch, String keyword, int start, int end) throws Exception;
	public int memCount(String memSearch, String keyword) throws Exception;
	public int memTotCount() throws Exception;
	public int memTotCount_3() throws Exception;
	public MemberDTO memView(int mem_idx) throws Exception;
	public void memUpdate(MemberDTO dto) throws Exception;
	public void memDelete(int mem_idx) throws Exception;

}
