package com.crowd.funding.interceptor;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.crowd.funding.maker.model.MakerDTO;
import com.crowd.funding.maker.service.MakerService;
import com.crowd.funding.member.model.MemberDTO;
import com.crowd.funding.member.service.MemberService;

public class KeepLoginInterceptor extends HandlerInterceptorAdapter {

	@Inject
	private MemberService memService;

	@Inject
	private MakerService maService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("#### KeepLoginInterceptor interceptor pre #####");
		HttpSession http = request.getSession();
		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");

		if (loginCookie != null) {
			System.out.println("쿠키가지고 있음");
			MemberDTO memDTO = memService.checkSessionKey(loginCookie.getValue());

			if (memDTO != null) {
				http.setAttribute("login", memDTO);
				http.setAttribute("mem_idx", memDTO.getMem_idx());

				if (maService.idx(memDTO.getMem_idx()) != 0) {
					http.setAttribute("maker_idx", maService.makeridx(memDTO.getMem_idx()));
				}
			}
		}

		return true;
	}

}
