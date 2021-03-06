package com.revature.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.services.LoginService;
import com.revature.services.UserService;

public class MasterDispatcher {

	private MasterDispatcher() {}
	
	public static String process(HttpServletRequest request, HttpServletResponse response) {
		switch(request.getRequestURI()) {
		case "/InClassServlets/login.do":
			return LoginService.login(request);
		case "/InClassServlets/home.do":
			return UserService.home(request);
		default:
			return "404.jsp";
		}
	}
}
