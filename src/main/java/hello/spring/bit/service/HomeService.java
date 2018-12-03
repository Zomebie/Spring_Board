package hello.spring.bit.service;

import org.springframework.ui.Model;

import hello.spring.bit.dto.UserDTO;

public interface HomeService {

	/*boolean login(UserDTO userDTO);

	String join(UserDTO userDTO);*/

	boolean delete(Model model);
	UserDTO list_userinfo(Model model);
}
