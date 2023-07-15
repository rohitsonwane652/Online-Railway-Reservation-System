package com.casestudy.filter;

import java.util.*;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;


@Component
public class RouteValidator {
	
	public static final List<String> openApiEndPoints=List.of(
			"/swagger-ui/index.html",
			"/swagger-ui/swagger-initializer.js",
			"/v3/api-docs/swagger-config",
			"/v3/api-docs",
			"/swagger-ui/swagger-ui.css",
			"/swagger-ui/swagger-ui-bundle.js",
			"/swagger-ui/index.css",
			"/swagger-ui/swagger-ui-standalone-preset.js",
			"/swagger-ui/swagger-initializer.js",
			"/swagger-ui/favicon-32x32.png",
			"/swagger-ui/favicon-16x16.png",
			"train/find",
			"train/search",
			"train/addtrain",
			"train/getallstations",
			"train/updateAcSeat",
			"train/updateSlSeat",
			"train/getstationinfo",
			"train/updatestation",
			"train/cancelacseat",
			"train/cancelslseat"
			);
	
	public static final  List<String> userApiEndPoints=List.of(
			
			);
	public static final  List<String> adminApiEndPoints=List.of(
			"train/addtrain",
			"train/updatetrain",
			"train/addstation",
			"train/updateAcSeat"
			);
	
	public Predicate<HttpServletRequest> isOpen = request ->
    openApiEndPoints.stream().anyMatch(uri -> request.getRequestURI().contains(uri));
	
//	 public Predicate<HttpServletRequest> isSecured = request ->
//     userApiEndPoints.stream().noneMatch(uri -> request.getRequestURI().contains(uri));
     
     public Predicate<HttpServletRequest> isSecured = request ->
     userApiEndPoints.stream().anyMatch(uri -> request.getRequestURI().contains(uri));
     
     public Predicate<HttpServletRequest> isAdminUrl = request ->
     adminApiEndPoints.stream().noneMatch(uri -> request.getRequestURI().contains(uri));
	

}
