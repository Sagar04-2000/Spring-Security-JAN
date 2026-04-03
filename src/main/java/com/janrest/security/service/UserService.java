package com.janrest.security.service;

import java.util.List;

import com.janrest.security.entity.User;

public interface UserService {

		void saveUser(User user);

		List<User> getUsers();
}
