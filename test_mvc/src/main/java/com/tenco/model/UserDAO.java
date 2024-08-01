package com.tenco.model;

import java.util.List;


public interface UserDAO {

	
	int createUser(UserDTO userDTO);
	
	
	UserDTO selectUserByName(String name);
	
	UserDTO selectUserById(int id);
	
	List<UserDTO> Allselect();
	
	int updateUser(UserDTO userDTO,int id);
	
	int deleteUser(int id);
	
}
