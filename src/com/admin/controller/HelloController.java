package com.admin.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/greet")
public class HelloController {
//	@RequestMapping("/welcome")
//	protected ModelAndView helloWorld() {
//		ModelAndView modelandview = new ModelAndView("HelloPage");
//		modelandview.addObject("welcomeMessage", "Hello World with annotation! ");
//		return modelandview;
//	}
//	
//	@RequestMapping("/selamat")
//	protected ModelAndView selamatDatang() {
//		ModelAndView modelandview = new ModelAndView("HelloPage");
//		modelandview.addObject("welcomeMessage", "Selamat Datang with annotation! ");
//		return modelandview;
//	}

	@RequestMapping("/welcome/{facultyName}/{userName}")
	protected ModelAndView helloWorld(@PathVariable Map<String, String> pathV) {
		String faculty = pathV.get("facultyName");
		String name = pathV.get("userName");
		ModelAndView modelandview = new ModelAndView("HelloView");
		modelandview.addObject("welcomeMessage", "Hello " + name + " Your faculty is: " + faculty);
		return modelandview;
	}
}