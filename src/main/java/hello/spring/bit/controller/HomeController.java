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
	
	// [���� ������] �α��� Ȩ ������
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return "login/home";
		
	}

	// �α��� Ȩ ���������� ���̵�� ��й�ȣ�� �Է��ϰ� �α��� ��ư�� ����!
	@RequestMapping("home_login")
	public String login(UserDTO userDTO, HttpServletRequest request) {

		if (dao.login(userDTO)) {
			System.out.println("===== HomeController >> �α��� ����! =====");
			HttpSession session = request.getSession();
			session.setAttribute("userId", userDTO.getId());
			return "login/main"; // �α��� ���� �� ���������� �����ֱ�
		} else {
			System.out.println("===== HomeController >> �α��� ����! =====");
			return "login/home"; // �α��� ���� �� �α��� Ȩ ������
		}

	}

	// [������ ��ȯ] �α��� Ȩ ���������� ȸ�����Դ���!
	@RequestMapping("join_write")
	public String join_write() {

		return "login/join";
	}

	// ȸ���������������� ȸ������ �ϷḦ ����!
	@RequestMapping("join")
	public String join(UserDTO userDTO) {
		// DB�� �� �ְ� �� ������ Ȯ���ϱ�

		if (dao.join(userDTO) != null) {

			System.out.println("===== HomeController >> ȸ������ ����! =====");
			return "login/home";

		} else {

			System.out.println("===== HomeController >> ȸ������ ����! =====");
			return "login/home";
		}

	}

	// [������ ��ȯ] �α׾ƿ������� �α��� Ȩ ��������!
	@RequestMapping("logout")
	public String logout() {
		return "login/home";
	}
	
	//[������ ��ȯ] ������ ������
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
		System.out.println("������ �����Ͽ����ϴ�.");
		return null;

	}

}
