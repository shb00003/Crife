package com.crowd.funding.admin.ad_member;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/*")
public class Ad_MemController {
	
	@Inject
	Ad_MemService adminMemService;
	
	@RequestMapping("memberList.do")

	 /*public String memberList(Model model) { 
		List<MemberDTO>memberList=adminMemService.memberList(); 
		model.addAttribute("dto", memberList);
		return "/admin/mem_list";*/

	 public ModelAndView mem_list(ModelAndView mav) {
		mav.setViewName("/admin/mem_list");
		mav.addObject("member", adminMemService.memberList());
		return mav;
	
	
	}
}
