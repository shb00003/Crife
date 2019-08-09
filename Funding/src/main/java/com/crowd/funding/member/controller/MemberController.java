package com.crowd.funding.member.controller;

import java.io.IOException;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.crowd.funding.member.SNSLogin;
import com.crowd.funding.member.SNSvalue;
import com.crowd.funding.member.model.LoginDTO;
import com.crowd.funding.member.model.MemberDTO;
import com.crowd.funding.member.service.MemberService;

@Controller
@RequestMapping(value = "/user/*")
public class MemberController {

	@Inject
	protected MemberService memService;
	@Inject
	private SNSvalue naverSNS;


	// 회원가입 페이지로 이동
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String joinGET() throws Exception {
		return "user/user_join";
	}
	// 회원가입 처리
	@RequestMapping(value = "/joinPOST", method = RequestMethod.POST)
	public String joinPOST(MemberDTO memDTO, RedirectAttributes redirect) throws Exception {

		// pw암호화 : BCrypt.hashpw(암호화할 비밀번호, 암호화된 비밀번호);
		String hashedPW = BCrypt.hashpw(memDTO.getMem_password(), BCrypt.gensalt());
		memDTO.setMem_password(hashedPW);

		memService.joinPOST(memDTO);
		redirect.addFlashAttribute("msg", "registered");

		return "redirect:/user/login";
	}
	
	// sns회원가입 페이지로 이동
		@RequestMapping(value = "/snsjoin", method = RequestMethod.GET)
		public String snsjoinGET() throws Exception {
			return "user/user_snsjoin";
		}
	// sns회원가입 처리
		@RequestMapping(value = "/snsjoinPOST", method = RequestMethod.POST)
		public String snsjoinPOST(MemberDTO memDTO, RedirectAttributes redirect) throws Exception {

			// pw암호화 : BCrypt.hashpw(암호화할 비밀번호, 암호화된 비밀번호);
			String hashedPW = BCrypt.hashpw(memDTO.getMem_password(), BCrypt.gensalt());
			memDTO.setMem_password(hashedPW);

			memService.snsjoinPOST(memDTO);
			redirect.addFlashAttribute("msg", "sns");

			return "redirect:/user/login";
		}
	
	@RequestMapping(value = "/emailConfirm", method = RequestMethod.GET)
	public String emailConfirm(@RequestParam String mem_email, @RequestParam String email_key, Model model) throws Exception{
		System.out.println("--------------- controller emailConfirm() : 이메일 인증 확인");
		System.out.println(mem_email + " / " + email_key);
		
		// 1: 회원가입
		int email_type = 1;
		int key = memService.chkKey(mem_email, email_type);
		
		if(key==0) {
			model.addAttribute("expired", key);
		}	
		
		System.out.println("*****"+key);

		memService.emailAuth(mem_email,email_key);
		model.addAttribute("mem_email", mem_email);

		return "user/confirm";
	}
	

		
	// 로그인 페이지로 이동
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGET(Model model, HttpSession session) throws IOException {
		
		//네이버 로그인에 필요한 url생성
		SNSLogin naverLogin = new SNSLogin(naverSNS);
		model.addAttribute("naverURL", naverLogin.getNaverAuthURL());
		
		return "user/login";
	}
	
	@RequestMapping(value = "/navercallback")
	public void callbackNAVER(@RequestParam String code, Model model , HttpSession session) throws Exception{
		
		// 1. code를 이용해서 access_token 받기
		// 2. access_token을 이용해서 사용자 profile 정보 가져오기
		SNSLogin snsLogin = new SNSLogin(naverSNS);
				
		MemberDTO snsUser = snsLogin.getUserProfile(code);
		System.out.println("Profile>>" + snsUser);
		model.addAttribute("snsUser", snsUser);
	
		// 3. DB 해당 유저가 존재하는 체크 
		MemberDTO mem = memService.snsLogin(snsUser);
		
		
		if(mem==null) {
			//회원가입 x sns유저
			model.addAttribute("msg", "0");
			return;
		}else {
			if(mem.getMem_type()==3) {
				System.out.println("휴면계정");
				model.addAttribute("msg", "3");
				// 내용 추가해야함 - 
				// 1년이내 로그인 시도하면, 휴면계정 풀리도록?
				// 휴면계정 DB에 회원정보 이동.??
				return;
			}
			
			System.out.println("sns 로그인 성공");
			// 4. 존재시 강제로그인
			model.addAttribute("mem", mem);
			model.addAttribute("msg", "1");
			
		}
			
	}

	@RequestMapping(value = "/loginPOST", method = RequestMethod.POST)
	public void loginPOST(LoginDTO logDTO, HttpSession http, Model model) throws Exception {
		// login 뷰에서 받은 데이터를 memDTO에 담는다.
		MemberDTO memDTO = memService.loginPOST(logDTO);

		System.out.println("##### 로그인 시도");
		System.out.println("### 아이디 : " + logDTO.getMem_email());
		System.out.println("### 비밀번호 : " + logDTO.getMem_password());

		// 아이디가 없거나, 비밀번호가 불일치 하면 메서드 종료
		if (memDTO == null) {
			System.out.println("### 아이디가 DB에 없다.");
			model.addAttribute("msg", "id");
			return;
		} else if (memDTO != null) {
			if (!BCrypt.checkpw(logDTO.getMem_password(), memDTO.getMem_password())) {
				System.out.println("### 비밀번호 불일치");
				model.addAttribute("msg", "pw");
				return;
			}
			if(memDTO.getMem_type()==3) {
				System.out.println("휴면계정");
				model.addAttribute("msg", "3");
				// 내용 추가해야함 - 
				// 1년이내 로그인 시도하면, 휴면계정 풀리도록?
				// 휴면계정 DB에 회원정보 이동.??
				return;
			}
			if(memDTO.getMem_email_cert()==0) {
				System.out.println("이메일 미인증");
				model.addAttribute("msg", "email");
				return;
			}				
			
			System.out.println("로그인 성공");
		}

		// login 뷰에서 받은 데이터를 memDTO에 담는다. -> mem에 저장
		model.addAttribute("mem", memDTO);

		// 자동로그인을 선택한 경우
		if (logDTO.isUseCookie()) {
			System.out.println("자동로그인 선택함");
			int amount = 60 * 60 * 24 * 3; // 3일동안 쿠키 유지
			Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * amount));
			memService.keepLogin(memDTO.getMem_email(), http.getId(), sessionLimit);
		}

		// 마지막 로그인 시간 업데이트
		memService.lastLogin(memDTO.getMem_email(), new Date());

	}
	
	@RequestMapping(value = "/loginCK", method = RequestMethod.GET) 
	public String loginPOST() throws Exception { 
		  return "user/loginPOST"; 
	}
	
	

	// 로그아웃 처리
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession http) throws Exception {
		Object ob = http.getAttribute("login");

		if (ob != null) {
			MemberDTO memDTO = (MemberDTO) ob;
			http.removeAttribute("login");
			http.invalidate();
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");

			if (loginCookie != null) {

				loginCookie.setPath("/");
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
				memService.keepLogin(memDTO.getMem_email(), "none", new Date());
			}
		}

		return "/user/logout";
	}
	


	// myinfo페이지 이동
	@RequestMapping(value = "/myinfo")
	public String myinfoGET(@RequestParam int mem_idx, Model model) throws Exception {

		model.addAttribute("myinfo", memService.myinfo(mem_idx));
		return "user/myinfo";
	}

	// myinfo - 수정
	@RequestMapping(value = "/myinfo_up")
	public String myinfoUP(@ModelAttribute MemberDTO memDTO, Model model, RedirectAttributes redirect) throws Exception {
		System.out.println("%%% 회원번호 : " + memDTO.getMem_idx() + " 수정 %%%");

		// 수정 전 정보
		MemberDTO memDTOpre = memService.myinfo(memDTO.getMem_idx());

		// 비밀번호 일치 확인
		if (!BCrypt.checkpw(memDTO.getMem_password(),memDTOpre.getMem_password())) {
			System.out.println("### 수정 - 비밀번호 불일치");
			redirect.addFlashAttribute("chkPW", "false");
			
			return "redirect:/user/myinfo?mem_idx=" + memDTO.getMem_idx();		
		}
		
		System.out.println("### 비밀번호 일치 - 수정");
		// pw암호화 : BCrypt.hashpw(암호화할 비밀번호, 암호화된 비밀번호);
		String hashedPW = BCrypt.hashpw(memDTO.getMem_password(), BCrypt.gensalt());
		memDTO.setMem_password(hashedPW);

		memService.myinfoUP(memDTO);

		
		return "redirect:/user/myinfo?mem_idx=" + memDTO.getMem_idx();
	}

	// myinfo - 삭제
	@RequestMapping(value = "/myinfo_del")
	public String myinfoDEL(@RequestParam int mem_idx, @ModelAttribute MemberDTO memDTO, RedirectAttributes redirect) throws Exception {
		System.out.println("%%% 회원번호 : " + mem_idx + " 탈퇴요청 %%%");
		
		// 수정 전 정보
		MemberDTO memDTOpre = memService.myinfo(memDTO.getMem_idx());

		// 비밀번호 일치 확인
		if (!BCrypt.checkpw(memDTO.getMem_password(),memDTOpre.getMem_password())) {
			System.out.println("### 탈퇴요청 - 비밀번호 불일치");
			redirect.addFlashAttribute("chkPW", "false");
					
			return "redirect:/user/myinfo?mem_idx=" + memDTO.getMem_idx();		
		}
		System.out.println("### 비밀번호 일치 - 탈퇴");
				
		// 진행중인 펀딩이 있는지? 확인후 진행
		// 참가중인 펀딩이 있는지 ? 확인후 진행
		memService.myinfoDEL(mem_idx);
		return "redirect:/user/logout";
	}
	
	
	@RequestMapping(value = "/userfind", method = RequestMethod.GET)
	public String userfindGET() throws Exception{
		return "user/userfind";
	}
	
	//아이디 찾기
	@RequestMapping(value = "/userfind_id", method = RequestMethod.POST)
	public String userfindID(@RequestParam String find, Model model) throws Exception{
		
		model.addAttribute("find", find);
		
		int chk = memService.userfindID(find);
				
		if(chk==0) {
			//System.out.println("아이디 없음");
			model.addAttribute("msg", "0");
		}else if(chk==1){
			//System.out.println("아이디 있음");
			model.addAttribute("msg", "1");
		}
		
		return "user/userfind";
	}
	
	//비밀번호 변경 이메일 발송
	@RequestMapping(value = "/userfind_pw", method = RequestMethod.POST)
	public String userfindPW(@RequestParam String findpw, Model model) throws Exception{
		
		memService.userfindPW(findpw);
		model.addAttribute("msg", "email");
		model.addAttribute("find", findpw);
			
		return "user/userfind";
	}
	
	@RequestMapping(value = "/resetpw", method = RequestMethod.GET)
	public String resetPW(@RequestParam String mem_email, @RequestParam String email_key, Model model) throws Exception{
		System.out.println("--------------- controller resetpw() : 비밀번호 재설정");
		System.out.println(mem_email + " / " + email_key);
		
		//만료된 링크 확인 , 3: 비밀번호 분실
		int email_type = 3;
		int key = memService.chkKey(mem_email, email_type);
		
		if(key==0) {
			model.addAttribute("expired", "expired");
		}		
			//System.out.println("*****"+key);
		model.addAttribute("email_key", email_key);
		model.addAttribute("mem_email", mem_email);

		return "user/resetPW";
	}
	
	@RequestMapping(value = "/resetpw", method = RequestMethod.POST)
	public String resetPW(@RequestParam String mem_password, @RequestParam String email_key, @RequestParam String mem_email) throws Exception{
		System.out.println("--------------- controller resetpw() : 비밀번호 재설정");
		System.out.println(mem_password + " / " + email_key+ " / " + mem_email);
		
		//비밀번호 암호화
		String hashedPW = BCrypt.hashpw(mem_password, BCrypt.gensalt());
		System.out.println(hashedPW);
		memService.resetPW(hashedPW, mem_email, email_key);

		return "user/login";
	}
	
	


}
