package com.janrest.security.config;

import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//iimport com.janrest.security.entity.User;
import com.janrest.security.repository.UserRepository;

@Service
public class CustomeUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		
		Optional<com.janrest.security.entity.User> user = userRepo.findByUserName(username);
		System.out.println("In loadUsername");
		/*return org.springframework.security.core.userdetails.User(
				user.get().getUserName(),
				user.get().getPassword(),
				null
				);*/
		return  org.springframework.security.core.userdetails.User
				.withUsername(user.get().getUserName()).
				password(user.get().getPassword()).build();
	
		
	}

}
