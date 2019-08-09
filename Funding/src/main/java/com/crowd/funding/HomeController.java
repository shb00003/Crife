package com.crowd.funding;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crowd.funding.member.model.MemberDAO;
import com.crowd.funding.member.model.MemberDTO;
import com.crowd.funding.project.model.ProjectDAO;
import com.crowd.funding.project.model.ProjectDTO;
import com.crowd.funding.project.service.ProjectService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Inject
	MemberDAO memberDao;
	
	@Inject
	ProjectService projectService;
	
	/*
	 * @RequestMapping(value = "/", method = RequestMethod.GET) public String
	 * home(Model model) throws Exception { return "home"; }
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) throws Exception {
		// 프로젝트 리스트를 DB에서 가져와서 모델에 넣음
		model.addAttribute("list", projectService.listProject());
		return "home";
	}
	
}
