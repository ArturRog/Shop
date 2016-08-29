package com.rog.webshop.service.user;


import com.rog.webshop.model.user.User;

public interface UserService {

	void save(User user);
	
	User findById(int id);
	
	User findBySso(String sso);
	
}