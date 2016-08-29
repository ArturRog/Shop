package com.rog.webshop.dao.user;


import com.rog.webshop.model.user.User;

public interface UserDao {

	void save(User user);
	
	User findById(int id);
	
	User findBySSO(String sso);
	
}

