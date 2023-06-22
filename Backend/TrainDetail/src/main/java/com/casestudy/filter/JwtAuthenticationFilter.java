package com.casestudy.filter;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.casestudy.util.JwtUtilService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	private String email;
	private String role;
	
	@Autowired
	private JwtUtilService jwtServiceutil;
	
	@Autowired
	private RouteValidator routeValidater;
	
	private static Logger logger=LoggerFactory.getLogger(JwtAuthenticationFilter.class);
	
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		
		if (routeValidater.isOpen.test(request)) {
            filterChain.doFilter(request, response);
            return;
        }
		
		String jwtToken = extractJwtToken(request);
		if (jwtToken != null) {
			
			if (jwtTokenIsValid(jwtToken)) {			
	
				if(!routeValidater.isAdminUrl.test(request)) {
					if(role.equals("admin")) {
						request.setAttribute("userName", email);
						
						filterChain.doFilter(request, response);
					}
					else if((routeValidater.isSecured.test(request)) && role.equals("user")) {
						request.setAttribute("userName", email);
						
						filterChain.doFilter(request, response);
					}
					else {
						String newuri = "/train/unauthorized";
						HttpServletRequest wRequest = new HttpServletRequestWrapper(request) {
							@Override
							public String getMethod() {
								return "GET";
							}
						};
						
						request.getRequestDispatcher(newuri).forward(wRequest, response);
						
					}
				}
				
				
				
				
				
		    }
			else {
				
				String newuri = "/train/invalid";
				HttpServletRequest wRequest = new HttpServletRequestWrapper(request) {
					@Override
					public String getMethod() {
						return "GET";
					}
				};
				
				request.getRequestDispatcher(newuri).forward(wRequest, response);
			}
		}
		else {

			String newuri = "/train/missingAuth";
			HttpServletRequest wRequest = new HttpServletRequestWrapper(request) {
				@Override
				public String getMethod() {
					return "GET";
				}
			};
			
			request.getRequestDispatcher(newuri).forward(wRequest, response);
			
		}
		
	 
	    
		
		
	}
	private String extractJwtToken(HttpServletRequest request) {
	    String header = request.getHeader("Authorization");
	    if (header != null && header.startsWith("Bearer ")) {
	        return header.substring(7);
	    }
	    return null;
	}
	 
	private boolean jwtTokenIsValid(String jwtToken) {
		try {
			
	      List<String>  credList= jwtServiceutil.validateToken(jwtToken);
	       this.email=credList.get(0);
	       this.role=credList.get(1);
	        
	        return true;
	    } catch (Exception ex) {
	        return false;
	    }
	}

}

