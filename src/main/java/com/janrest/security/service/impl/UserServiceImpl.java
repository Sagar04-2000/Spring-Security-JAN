package com.janrest.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.janrest.security.entity.User;
import com.janrest.security.repository.UserRepository;
import com.janrest.security.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		//From Github Remote
		
		//From Github local 
		return userRepository.findAll();
	}


}
