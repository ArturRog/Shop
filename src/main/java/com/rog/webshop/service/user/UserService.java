package com.rog.webshop.service.user;


import com.rog.webshop.model.user.User;

import java.util.List;

public interface UserService {

	void save(User user);
	
	User findById(int id);
	
	User findBySso(String sso);

	User findByEmail(String email);
	void updateUser(User user);

	List<User> getAllUsers();
}