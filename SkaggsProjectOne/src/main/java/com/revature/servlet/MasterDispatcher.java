package com.revature.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.LoginService;
import com.revature.service.UserService;

public class MasterDispatcher {

	public static String process(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException {
		switch(request.getRequestURI()) {
		case "/SkaggsProjectOne/login.do":
			return LoginService.login(request);
		case "/SkaggsProjectOne/home.do":
			return UserService.home(request);
		case "/SkaggsProjectOne/fm.do":
			return UserService.fm(request);
		default:
			return "404.jsp";
		}
	}
}