package com.crowd.funding.admin.ad_project;

import java.util.HashMap;
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
	Ad_ProjectService proService;

	@RequestMapping("/adminhome.do")
	public String admin() {
		
		return "admin/admin_home";
	}

	@RequestMapping("/projectall.do")
	public ModelAndView projectAll (@RequestParam(defaultValue="") String searchOption,
	                                @RequestParam(defaultValue="") String keyword) throws Exception{
		List<ProjectDTO> projectAll=proService.projectAll(searchOption, keyword);
		int count=proService.proCount(searchOption, keyword);  //레코드 갯수
		ModelAndView mav=new ModelAndView(); //모델과 뷰

		Map<String, Object> map=new HashMap<String, Object>();
		map.put("list", projectAll); 
		map.put("count", count);  //레코드 갯수
		map.put("searchOption", searchOption);  //검색옵션
		map.put("keyword", keyword); //검색 키워드
		mav.addObject("map", map);  //맵에 저장된 데이터를 mav에 저장
		
		mav.setViewName("/admin/project_all"); // 전달할 데이터
		return mav;
	}

}
