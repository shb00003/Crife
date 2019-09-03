 package com.crowd.funding.admin.ad_project;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.crowd.funding.community.service.Pager;
import com.crowd.funding.project.model.ProjectDTO;

@Controller
@RequestMapping("/admin/*")
public class Ad_ProjectController {

	@Inject
	Ad_ProjectService proService;
	


	@RequestMapping("/projectSearch.do")
	public ModelAndView proSearch (@RequestParam(defaultValue="pro_all") String searchOption,
	                               @RequestParam(defaultValue="") String keyword, int curPage) throws Exception {

		int count=proService.searchCount(searchOption, keyword);
		Pager pager = new Pager(count, curPage);
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		
		List<ProjectDTO> proSearch=proService.proSearch(searchOption, keyword, start, end);
		ModelAndView mav=new ModelAndView(); //모델과 뷰
		
		HashMap<String, Object> map=new HashMap<>();
		map.put("list", proSearch); 
		map.put("count", count);  //레코드 갯수
		map.put("searchOption", searchOption);  //검색옵션
		map.put("keyword", keyword); //검색 키워드
	
		mav.addObject("map", map);  //맵에 저장된 데이터를 mav에 저장
		System.out.println(count+"여기야 여기~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		mav.setViewName("admin/project/pro_search"); // 전달할 데이터
		return mav;
	}
	// 프로젝트 리스트 (조회전)
	@RequestMapping("/projectList.do")
	public String projectList() throws Exception {
		return "admin/project/pro_all";
	}
	
	/*
	 * @RequestMapping("/projectApply.do") public String projectApply() throws
	 * Exception { return "admin/project/pro_apply"; }
	 * 
	 * @RequestMapping("/projectProgress.do") public String projectProgress() throws
	 * Exception { return "admin/project/pro_progress"; }
	 * 
	 * @RequestMapping("/projectProgress.do") public String projectProgress() throws
	 * Exception { return "admin/project/pro_progress"; }
	 */

}
