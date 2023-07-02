package com.casestudy.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import java.security.Key;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {
	
	
	static final String secret="5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";
	
	
	
	
	public void validateToken(final String token){
//		Jws<Claims> claimsJws=Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
		Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
	}
	
	
	
	public String genarateToken(String email,String role) {
		
		Map<String, Object> claims=new HashMap<>();
		return createToken(claims,email,role);
		
	}
	
	
	private String createToken(Map<String, Object> claims,String email,String role) {
		claims.put("role", role);
//		System.out.println(role);
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(email)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
				.signWith(getSignKey(),SignatureAlgorithm.HS256).compact();
		
	}
	
	private Key getSignKey() {
		
		byte[] keyButes=Decoders.BASE64.decode(secret);
		return Keys.hmacShaKeyFor(keyButes);
		
		
	}
}
