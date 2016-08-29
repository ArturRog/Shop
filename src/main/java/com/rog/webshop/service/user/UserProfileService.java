package com.rog.webshop.service.user;


import com.rog.webshop.model.user.UserProfile;

import java.util.List;

public interface UserProfileService {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
