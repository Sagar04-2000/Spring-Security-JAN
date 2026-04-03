package com.janrest.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.janrest.security.entity.User;
import com.janrest.security.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/signUp")
	public String signUp(@RequestBody User user) {
		System.out.println("Saving User");
		userService.saveUser(user);
		return "User Saved";
	}
	
	@GetMapping("/getUsers")
	public List<User> getUsers(){
		System.out.println("Returning Users");
		return userService.getUsers();
	}

}
