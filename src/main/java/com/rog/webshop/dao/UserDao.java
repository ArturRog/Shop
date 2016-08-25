package com.rog.webshop.dao;


import com.rog.webshop.model.User;

public interface UserDao {

	User findById(int id);
	
	User findBySSO(String sso);
	
}

