package com.user.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/auth")
public class AuthController {
	@RequestMapping("/login")
	protected ModelAndView login(@PathVariable Map<String, String> pathV) {
//		String faculty = pathV.get("facultyName");
//		String name = pathV.get("userName");
		ModelAndView modelandview = new ModelAndView("LoginView");
		modelandview.addObject("welcomeMessage", "Hello");
		return modelandview;
	}

//	@RequestMapping("/logout")
//	protected ModelAndView helloWorld(@PathVariable Map<String, String> pathV) {
//		String faculty = pathV.get("facultyName");
//		String name = pathV.get("userName");
//		ModelAndView modelandview = new ModelAndView("HelloView");
//		modelandview.addObject("welcomeMessage", "Hello " + name + " Your faculty is: " + faculty);
//		return modelandview;
//	}
//	
	@RequestMapping("/signup")
	protected ModelAndView signUp(@PathVariable Map<String, String> pathV) {
//		String faculty = pathV.get("facultyName");
//		String name = pathV.get("userName");
		ModelAndView modelandview = new ModelAndView("SignUpView");
		modelandview.addObject("welcomeMessage", "Hello");
		return modelandview;
	}
}