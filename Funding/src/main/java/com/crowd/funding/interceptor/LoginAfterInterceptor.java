package com.crowd.funding.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginAfterInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("#### LoginAfterInterceptor interceptor pre #####");

		// 로그인 후 로그인페이지 or 회원가입 페이지로 이동할 경우 > HOME으로 이동
		HttpSession session = request.getSession();
		if (session.getAttribute("login") != null) {
			response.sendRedirect(request.getContextPath() + "/");
			return false;
		}
		return true;
	}
}