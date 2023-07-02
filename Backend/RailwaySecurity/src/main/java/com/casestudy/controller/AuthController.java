package com.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.model.JwtResponseModel;
import com.casestudy.model.UserCredential;
import com.casestudy.model.UserData;
import com.casestudy.service.AuthService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@PostMapping("/register")
	public String addNewUser(@RequestBody UserData userData) {
	
		return authService.saveUser(userData);
		
	}
	
	@PostMapping("/token")
	public ResponseEntity<?> genToken(@RequestBody UserCredential userCred) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userCred.getEmail(), userCred.getPassword()));
		}
		catch(BadCredentialsException e) {
			throw new RuntimeException("Invalid User",e);
		}
		String role=authService.retrieveRole(userCred.getEmail());
		String token = authService.generateToken(userCred.getEmail(),role);
		return ResponseEntity.ok(new JwtResponseModel(token));
	}
	
	@GetMapping("/validate")
	public String validateToken(@RequestParam("token") String token) {
		authService.validateToken(token);
		return "Token is valid";
	}
	
	@GetMapping("/test")
	public String test() {
		return "Success";
	}
}
