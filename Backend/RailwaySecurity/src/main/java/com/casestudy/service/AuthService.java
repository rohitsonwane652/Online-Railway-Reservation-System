package com.casestudy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.casestudy.exception.UserexistException;
import com.casestudy.model.UserData;
import com.casestudy.repository.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@Autowired
	private JwtService jwtService;
	
	public String saveUser(UserData userData) {
		Optional<UserData> user = userRepo.findByEmail(userData.getEmail());
		if(user.isPresent()) {
			throw new UserexistException("User already exist with Email id ", userData.getEmail());
		}
		userData.setUserId(sequenceGeneratorService.generateSequence(UserData.SEQUENCE_NAME));
		userData.setPassword(passwordEncoder.encode(userData.getPassword()));
		if(userData.getRole() ==null || userData.getRole() == "") {
			userData.setRole("user");
			
		}else {
			userData.setRole("admin");
		}
		userRepo.save(userData);
		return "User added sucessfully";
		
	}
	
	
	public String generateToken(String email,String role) {
		
		return jwtService.genarateToken(email,role);
		
		
	}
	
	public void validateToken(String token) {
		
		jwtService.validateToken(token);
	}


	public String retrieveRole(String email) {
		
		UserData userCredential = userRepo.findByEmail(email).orElse(null);
		
		return userCredential.getRole();
	}
}
