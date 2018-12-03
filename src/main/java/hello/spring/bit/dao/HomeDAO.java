package hello.spring.bit.dao;

import java.util.List;

import org.springframework.ui.Model;

import hello.spring.bit.dto.UserDTO;

public interface HomeDAO {

	
	boolean login(UserDTO userDTO);
	String join(UserDTO userDTO);
	boolean delete(String userId);
	UserDTO list_userinfo(String userId);
	List<UserDTO> list_username();
}
