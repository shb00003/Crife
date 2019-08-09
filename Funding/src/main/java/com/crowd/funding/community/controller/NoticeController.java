package com.crowd.funding.community.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crowd.funding.community.model.NoticeDAO;
import com.crowd.funding.community.model.NoticeDTO;

@Controller
@RequestMapping("/community/*")
public class NoticeController {

	@Inject
	NoticeDAO noticeDao;

	@RequestMapping("/notice/notice.do")
	public ModelAndView list() throws Exception {
		List<NoticeDTO> list = noticeDao.listAll(0, 0, "", "");	// 목록
		ModelAndView mav = new ModelAndView();
		mav.setViewName("community/notice/notice");	// 이동할 페이지
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);	// 맵에 자료 저장
		mav.addObject("map", map);	// 데이터 저장
		return mav;	
	}
	
	@RequestMapping("/notice/write.do")
	public String write() {
		return "community/notice/notice_write";
	}
	
	@RequestMapping("/notice/insert.do")
	public String insert(@ModelAttribute NoticeDTO dto, HttpSession session) throws Exception {
		// 로그인한 사용자의 아이디
		String mem_email = (String) session.getAttribute("mem_idx");
		dto.setMem_email(mem_email);
		System.out.println(mem_email);
		// 레코드가 저장됨
		noticeDao.insert(dto);
		// 목록 갱신
		return "redirect:/community/notice/notice.do";
	}
}
