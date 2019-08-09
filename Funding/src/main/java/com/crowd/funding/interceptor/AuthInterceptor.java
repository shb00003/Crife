package com.crowd.funding.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("#### AuthInterceptor interceptor pre #####");
		HttpSession http = request.getSession();
		if (http.getAttribute("login") == null) {
			System.out.println("current user is not logged");
			response.sendRedirect("/funding/user/login");
			return false;
		}

		return true;
	}

	// 로그인 페이지로 이동 전에, 페이지 정보 저장
	private void saveURI(HttpServletRequest request) {
		System.out.println("#### AuthInterceptor interceptor : saveURI #####");
		String uri = request.getRequestURI();
		String query = request.getQueryString();

		if (query == null || query.equals("null")) {
			query = "";
		} else {
			query = "?" + query;
		}

		if (request.getMethod().equals("GET")) {
			System.out.println("URI : " + uri + query);
			request.getSession().setAttribute("destination", uri + query);
		}
	}

}
