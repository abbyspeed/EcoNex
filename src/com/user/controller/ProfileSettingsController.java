package com.user.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/profile")
public class ProfileSettingsController {
	@RequestMapping("/settings")
	protected ModelAndView settings(@PathVariable Map<String, String> pathV) {
//		String faculty = pathV.get("facultyName");
//		String name = pathV.get("userName");
		ModelAndView modelandview = new ModelAndView("ProfileSettingsView");
		modelandview.addObject("welcomeMessage", "Hello");
		return modelandview;
	}
}
