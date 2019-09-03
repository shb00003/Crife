package com.crowd.funding.admin.ad_member;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	
	// 회원관리 (조회 전)
	
	@RequestMapping("/memListGET.do")
	public String memListGET(@RequestParam(defaultValue = "mem_name") String memSearch,
			@RequestParam(defaultValue = "") String keyword, Model model) throws Exception {
		
		int totcount = ad_memService.memTotCount();
		model.addAttribute("memTotCount", totcount);
		System.out.println("memTotcount"+totcount);
		return "admin/member/mem_list";
	}
	
	// 회원관리 (조회 후)
	// url 주소에 키워드값 넣는 방법 알아보기!!!!!
	@RequestMapping("/memList.do") 
	public ModelAndView memList(@RequestParam(defaultValue = "mem_name") String memSearch,
			@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "1") int curPage,
			 Model model) throws Exception {

		// 레코드 갯수 계산
		int totcount = ad_memService.memTotCount();
		model.addAttribute("memTotCount", totcount);
		int count = ad_memService.memCount(memSearch, keyword);
		// 페이지 관련 설정 (community.service.Pager)
		Pager pager = new Pager(count, curPage);
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		// 회원목록
		List<MemberDTO> list = ad_memService.memList(memSearch, keyword, start, end);
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("count", count);
		map.put("pager", pager);
		map.put("memSearch", memSearch); // 검색옵션
		map.put("keyword", keyword); // 검색 키워드
		mav.setViewName("/admin/member/mem_list");
		mav.addObject("map", map);
		return mav;
	}
	
	// 휴먼회원 관리 (조회 전)
	@RequestMapping("/memDormancyGET.do") 
	public String memDormancyGET(@RequestParam(defaultValue = "mem_name") String memSearch,
			@RequestParam(defaultValue = "") String keyword, Model model) throws Exception {
		int totcount3 = ad_memService.memTotCount_3();
		model.addAttribute("memTotCount_3", totcount3);
		System.out.println("memTotcount_3"+totcount3);
		return "/admin/member/mem_dormancy";
	}

	// 휴먼회원 관리 (조회 후)
	@RequestMapping("/memDormancy.do")

	public ModelAndView memDormancy(@RequestParam(defaultValue = "mem_name") String memSearch,
			@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "1") int curPage,
			Model model) throws Exception {
		// 레코드 갯수 계산
		int totcount3 = ad_memService.memTotCount_3();
		System.out.println("totcount3:"+totcount3);
		model.addAttribute("memTotCount_3", totcount3);
		int count = ad_memService.memCount(memSearch, keyword);
		// 페이지 관련 설정 (community.service.Pager)
		Pager pager = new Pager(count, curPage);
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		// 회원목록
		List<MemberDTO> list = ad_memService.memList(memSearch, keyword, start, end);
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("count", count);
		map.put("pager", pager);
		map.put("memSearch", memSearch); // 검색옵션
		map.put("keyword", keyword); // 검색 키워드
		mav.setViewName("/admin/member/mem_dormancy");
		mav.addObject("map", map);
		return mav;
	}

	@RequestMapping("memView/{mem_idx}") // 회원상세보기
	public ModelAndView memView(@PathVariable int mem_idx, ModelAndView mav) throws Exception {
		mav.setViewName("admin/member/mem_view");
		mav.addObject("dto", ad_memService.memView(mem_idx));
		return mav;
	}

}
