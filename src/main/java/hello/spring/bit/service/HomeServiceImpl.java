package hello.spring.bit.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hello.spring.bit.dao.HomeDAO;
import hello.spring.bit.dto.UserDTO;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	HomeDAO dao;

	/*
	 * @Override public boolean login(UserDTO userDTO) {
	 * 
	 * return dao.login(userDTO); }
	 * 
	 * @Override public String join(UserDTO userDTO) {
	 * 
	 * return dao.join(userDTO); }
	 */

	@Override
	public boolean delete(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String userId = (String) request.getParameter("userId");

		if(dao.delete(userId)) {
			
			return true;
		}
		return false;
	}

	@Override
	public UserDTO list_userinfo(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String userId = (String) request.getParameter("userId");

		UserDTO userDTO = dao.list_userinfo(userId);

		return userDTO;
	}

}
