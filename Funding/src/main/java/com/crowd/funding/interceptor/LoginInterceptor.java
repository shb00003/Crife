package com.crowd.funding.interceptor;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.crowd.funding.maker.service.MakerService;
import com.crowd.funding.member.model.MemberDTO;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Inject
	MakerService maService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("#####LoginInterceptor pre");
		System.out.println(request.getRequestURI());

		HttpSession http = request.getSession();

		// 기존의 로그인 정보 제거
		if (http.getAttribute("login") != null) {
			System.out.println("#####clear login data before");
			System.out.println("#####기존로그인정보 제거");
			http.removeAttribute("login");
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("#####LoginInterceptor post");
		System.out.println(request.getRequestURI());

		HttpSession http = request.getSession();

		// 모델에 담긴 모든 데이터를 가져옴
		ModelMap modelMap = modelAndView.getModelMap();
		MemberDTO memDTO = (MemberDTO) modelMap.get("mem");

		// 0 : sns가입안된 계정, 1:sns로그인 성공, id : id가 없다, pw : 비밀번호 불일치, 3 : 휴면계정
		Object msg = modelMap.get("msg");
		MemberDTO snsUser = (MemberDTO) modelMap.get("snsUser");

		http.setAttribute("msg", msg);

		// httpSession에 컨트롤러에서 저장한 login을 저장
		if (memDTO != null) {

			if (memDTO.getMem_type() == 3) {
				System.out.println("#####휴면계정! 로그인 실패 ");

			} else {

				System.out.println("#####로그인성공");
				http.setAttribute("login", memDTO);

				if (maService.idx(memDTO.getMem_idx()) != 0) {
					http.setAttribute("maker_idx", maService.makeridx(memDTO.getMem_idx()));
				}
				if (request.getParameter("useCookie") != null) {
					System.out.println("쿠키있음");
					// 쿠키생성 변수 : loginCookie에 session의 아이디값 보관
					Cookie loginCookie = new Cookie("loginCookie", http.getId());
					loginCookie.setPath("/");
					loginCookie.setMaxAge(60 * 60 * 24 * 3); // 3일동안
					response.addCookie(loginCookie); // 쿠키 전송

					// 브라우저 종료 후, 해당 페이지를 쿠키가 유지되는 5분이내에 접속하면 로그인이 유지되어 있다.?
				}
			}
		} else if (memDTO == null) {
			System.out.println("#####로그인 실패 ");
		}

		System.out.println("ㄱㄱㄱㄱ msg : " + msg);

		// 이전에 하던 페이지로 이동, or home으로 이동
		Object destination = http.getAttribute("destination");
		System.out.println("이동할 경로 : " + destination);
		if (msg == "0") {
			http.setAttribute("snsUser", snsUser);
			response.sendRedirect("/funding/user/snsjoin");
		} else {
			response.sendRedirect(destination != null ? (String) destination : "/funding/user/loginCK");
		}
	}

}
