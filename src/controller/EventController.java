package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dbAccess.EventDAO;
import model.Event;
import model.User;

@Controller
@RequestMapping("/Events")
public class EventController {
	
	ModelAndView model;
	
	EventDAO eventDAO = new EventDAO();
	
	@RequestMapping("/ViewAll")
	public ModelAndView getAllEvents(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}
		
		List<Event> eventList = eventDAO.getAll();
		List<Event> upcomingList = new ArrayList<Event>();
		List<Event> ongoingList = new ArrayList<Event>();
		
		for(Event event : eventList) {
			if(event.getStatus() == "Upcoming") {
				upcomingList.add(event);
				
			} else if(event.getStatus() == "Ongoing") {
				ongoingList.add(event);
			}
		}
		
		model = new ModelAndView("EventsView");
		
		model.addObject("user", user);
		model.addObject("eventList", eventList);
		model.addObject("upcomingList", upcomingList);
		model.addObject("ongoingList", ongoingList);
		
		return model;
	}
	
	@RequestMapping("/DataEntry/{eventid}")
	public ModelAndView showDataEntry(@PathVariable ("eventid") String eventid) {
		int eventId = Integer.parseInt(eventid);
		
		Event event = eventDAO.findById(eventId);
		
		model = new ModelAndView("DataEntryView");
		
		model.addObject("eventId", eventId);
		model.addObject("event", event);
		
		return model;
	}
	
	@RequestMapping("/Instructions/{eventid}")
	public ModelAndView showInstructions(@PathVariable ("eventid") String eventid) {
		int eventId = Integer.parseInt(eventid);
		
		model = new ModelAndView("InstructionsView");
		
		model.addObject("eventId", eventId);
		
		return model;
	}
	
	@RequestMapping("/EventInfo/{eventid}")
	public ModelAndView showEventInfo(@PathVariable ("eventid") String eventid) {
		int eventId = Integer.parseInt(eventid);
		
		model = new ModelAndView("EventInfoView");
		
		model.addObject("eventId", eventId);
		
		return model;
	}
	
	@RequestMapping("/ProjectImpact/{eventid}")
	public ModelAndView showProjectImpact(@PathVariable ("eventid") String eventid) {
		int eventId = Integer.parseInt(eventid);
		
		model = new ModelAndView("ProjectImpactView");
		
		model.addObject("eventId", eventId);
		
		return model;
	}
}
