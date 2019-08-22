package com.crowd.funding.admin.ad_member;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.crowd.funding.community.service.Pager;
import com.crowd.funding.member.model.MemberDTO;

@Controller
@RequestMapping("/admin/*")
public class Ad_MemController {
	
	@Inject
	Ad_MemService ad_memService;
	
	@RequestMapping("memberList.do")  //회원목록 및 조회
	 public ModelAndView memList(@RequestParam(defaultValue ="mem_all") String memSearch,
			                     @RequestParam(defaultValue ="") String keyword,
			                     @RequestParam(defaultValue ="1") int curPage) 
			                    throws Exception{
		//레코드 갯수 계산
		int count=ad_memService.memCount(memSearch, keyword); 
		// 페이지 관련 설정 (community.service.Pager)
		Pager pager=new Pager(count, curPage); 
		int start=pager.getPageBegin();
		int end=pager.getPageEnd();
		//회원목록
		List<MemberDTO> list=ad_memService.memList(memSearch, keyword, start, end);
		ModelAndView mav=new ModelAndView();
		HashMap<String, Object> map=new HashMap<>();
		map.put("list", list);
		map.put("count", count);
		map.put("pager", pager);
		map.put("memSearch", memSearch); //검색옵션
		map.put("keyword", keyword); //검색 키워드
		mav.setViewName("/admin/mem_list");
		mav.addObject("map", map);
		return mav;
	}
	
	@RequestMapping("memberView/{mem_idx}") //회원상세보기
	public ModelAndView memView(@PathVariable int mem_idx, 
		                        ModelAndView mav)throws Exception{
		mav.setViewName("admin/mem_view");
		mav.addObject("dto", ad_memService.memView(mem_idx));
		return mav;
	}
	
}


