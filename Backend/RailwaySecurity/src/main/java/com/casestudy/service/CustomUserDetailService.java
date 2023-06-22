package com.casestudy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.casestudy.config.CustomeUserDetails;
import com.casestudy.model.UserData;
import com.casestudy.repository.UserRepository;

public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<UserData> credentials=userRepo.findByEmail(email);
		return credentials.map(CustomeUserDetails::new).orElseThrow( () -> new UsernameNotFoundException("No user found with Email"+email));
	}
}	
