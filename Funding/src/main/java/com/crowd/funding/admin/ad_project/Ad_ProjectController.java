package com.crowd.funding.admin.ad_project;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.crowd.funding.project.model.ProjectDTO;

@Controller
@RequestMapping("/admin/*")
public class Ad_ProjectController {

	@Inject
	Ad_ProjectService adProjectService;

	@RequestMapping("adminhome.do")
	public String admin() {
		
		return "admin/admin_home";
	}

	@RequestMapping("projectall.do")
	public ModelAndView projectAll(ModelAndView mav) {

		// 포워딩할 뷰의 이름
		mav.setViewName("/admin/project_all"); // 전달할 데이터
		mav.addObject("list", adProjectService.projectAll());

		return mav;

	}

}
