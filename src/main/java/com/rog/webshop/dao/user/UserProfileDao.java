package com.rog.webshop.dao.user;


import com.rog.webshop.model.user.UserProfile;

import java.util.List;

public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
