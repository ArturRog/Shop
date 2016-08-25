package com.rog.webshop.service;


import com.rog.webshop.model.User;

public interface UserService {

	User findById(int id);
	
	User findBySso(String sso);
	
}