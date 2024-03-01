package com.model.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.model.User;
import com.model.Repository.UserRepository;

public class UserDetailServiceImpl implements UserDetailsService {

	
	@Autowired
	UserRepository repository;
	//  we get the user from database and then return the authentication
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// fetching user from database
		User user = repository.getUserByUserName(username);
		
		if(user==null) {
			throw new UsernameNotFoundException("Could not found the user !! ");
		}
		
		CustomUserDetails customUserDetails = new CustomUserDetails(user);
		return customUserDetails;
	}

}
