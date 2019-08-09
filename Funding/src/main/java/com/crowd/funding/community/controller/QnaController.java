package com.crowd.funding.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/community/*")
public class QnaController {
	
	@RequestMapping("qna/qna.do")
	public String qna(Model model) {
		model.addAttribute("qna", "Q&A 페이지입니다.");
		return "community/qna/qna";
	}

}
