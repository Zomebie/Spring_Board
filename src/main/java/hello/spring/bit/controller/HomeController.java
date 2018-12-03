package hello.spring.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hello.spring.bit.dao.HomeDAO;
import hello.spring.bit.dto.UserDTO;
import hello.spring.bit.service.HomeService;

@Controller
public class HomeController {

	@Autowired
	HomeService homeService; // DI
	
	@Autowired
	HomeDAO dao;
	
	// [시작 페이지] 로그인 홈 페이지
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return "login/home";
		
	}

	// 로그인 홈 페이지에서 아이디와 비밀번호를 입력하고 로그인 버튼을 누름!
	@RequestMapping("home_login")
	public String login(UserDTO userDTO, HttpServletRequest request) {

		if (dao.login(userDTO)) {
			System.out.println("===== HomeController >> 로그인 성공! =====");
			HttpSession session = request.getSession();
			session.setAttribute("userId", userDTO.getId());
			return "login/main"; // 로그인 성공 시 메인페이지 보여주기
		} else {
			System.out.println("===== HomeController >> 로그인 실패! =====");
			return "login/home"; // 로그인 실패 시 로그인 홈 페이지
		}

	}

	// [페이지 전환] 로그인 홈 페이지에서 회원가입누름!
	@RequestMapping("join_write")
	public String join_write() {

		return "login/join";
	}

	// 회원가입페이지에서 회원가입 완료를 누름!
	@RequestMapping("join")
	public String join(UserDTO userDTO) {
		// DB에 값 넣고 잘 들어갔는지 확인하기

		if (dao.join(userDTO) != null) {

			System.out.println("===== HomeController >> 회원가입 성공! =====");
			return "login/home";

		} else {

			System.out.println("===== HomeController >> 회원가입 실패! =====");
			return "login/home";
		}

	}

	// [페이지 전환] 로그아웃누르면 로그인 홈 페이지로!
	@RequestMapping("logout")
	public String logout() {
		return "login/home";
	}
	
	//[페이지 전환] 관리자 페이지
	@RequestMapping("admin")
	public String admin(Model model) {
		
		model.addAttribute("UserDTO",dao.list_username());
		return "login/admin";

	}
	
	@RequestMapping("info")
	public String info(Model model,HttpServletRequest request) {
		
		model.addAttribute("request",request);
		UserDTO userDTO=homeService.list_userinfo(model);
		model.addAttribute("UserDTO", userDTO);
		return "login/info";

	}
	@RequestMapping("delete")
	public String delete(Model model,HttpServletRequest request) {
		
		model.addAttribute("request",request);
		
		if(homeService.delete(model)) {
			
			return "redirect:admin";
		}
		System.out.println("삭제에 실패하였습니다.");
		return null;

	}

}
