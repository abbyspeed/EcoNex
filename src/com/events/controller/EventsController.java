package com.events.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/events")
public class EventsController {
	@RequestMapping("/all")
	protected ModelAndView events() {
//		String faculty = pathV.get("facultyName");
//		String name = pathV.get("userName");
		ModelAndView modelandview = new ModelAndView("EventsView");
		modelandview.addObject("welcomeMessage", "Hello");
		return modelandview;
	}
}