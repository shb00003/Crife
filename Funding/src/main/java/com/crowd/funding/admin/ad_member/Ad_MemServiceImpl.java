package com.crowd.funding.admin.ad_member;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.crowd.funding.member.model.MemberDTO;

@Service
public class Ad_MemServiceImpl implements Ad_MemService {

	@Inject
	Ad_MemberDAO ad_memDao;

	@Override
	public List<MemberDTO> memList(String memSearch, String keyword,  
			                       int start, int end) throws Exception {
		
		return ad_memDao.memList(memSearch, keyword, start, end);
	}

	@Override
	public int memCount(String memSearch, String keyword) throws Exception {
		
		return ad_memDao.memCount(memSearch, keyword);
	}

	@Override
	public int memTotCount() throws Exception {
	
		return ad_memDao.memTotCount();
	}
	
	@Override
	public int memTotCount_3() throws Exception {
		
		return ad_memDao.memTotCount_3();
	}

	@Override
	public MemberDTO memView(int mem_idx) throws Exception {
		
		return ad_memDao.memView(mem_idx);
	}

	@Override
	public void memUpdate(MemberDTO dto) throws Exception {
		ad_memDao.memUpdate(dto);
		
	}

	@Override
	public void memDelete(int mem_idx) throws Exception {
		ad_memDao.memDelete(mem_idx);
		
	}
	
	
}
