package com.crowd.funding.admin.manager;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("admin/*")
public class ManagerController {
	
	@Inject
	ManagerService managerService;
	
	@RequestMapping("/adminhome.do")  //로그인 후 시작화면
	public String admin() throws Exception {
		
		return "admin/admin_home";
	}
	
	@RequestMapping("managerList.do")
	public ModelAndView listManager(ModelAndView mav) throws Exception {
		List<ManagerDTO> items=managerService.listManager();
		mav.setViewName("/admin/manager_list");
		mav.addObject("list", items);
		return mav;
	}
	
	@RequestMapping("managerRegister.do")
	public String register(@ModelAttribute ManagerDTO dto) 
			               throws Exception{
		managerService.insertManager(dto);
		return "redirect:/admin/managerList.do";
		
	}
	
	@RequestMapping("login.do")   //관리자로그인
	public String login() throws Exception {
		return "admin/admin_login";
	}

	@RequestMapping("loginCheck.do")
	public ModelAndView loginCheck(ManagerDTO dto, 
			                       HttpSession session) throws Exception {
		boolean result=managerService.loginCheck(dto, session);
		ModelAndView mav=new ModelAndView();
		
		if(result) {
			mav.setViewName("admin/admin_home");
			mav.addObject("message", "로그인이 되지 않았습니다.");
		}
		return mav;
	}
	
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session, 
			                   ModelAndView mav) throws Exception {
		managerService.logout(session);
		mav.setViewName("admin/admin_login");
		mav.addObject("message","로그아웃 되었습니다.");
		return mav;
	}
	
}















