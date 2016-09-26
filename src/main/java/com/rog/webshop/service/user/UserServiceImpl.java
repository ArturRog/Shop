package com.rog.webshop.service.user;


import com.rog.webshop.dao.user.UserDao;
import com.rog.webshop.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	public void save(User user){
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.save(user);
	}
	
	public User findById(int id) {
		return dao.findById(id);
	}

	public User findByEmail(String email) {
		return dao.findByEmail(email);
	}

	public User findBySso(String sso) {
		return dao.findBySSO(sso);
	}

	public void updateUser(User user) {
		dao.updateUser(user);
	}

	public List<User> getAllUsers(){
		return dao.getAllUsers();
	}
}
