package com.rog.webshop.service;


import com.rog.webshop.model.User;

public interface UserService {

	void save(User user);
	
	User findById(int id);
	
	User findBySso(String sso);
	
}