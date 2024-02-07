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

import dbAccess.ConsumptionDAO;
import dbAccess.ElectricityDAO;
import dbAccess.EventDAO;
import dbAccess.HousingDAO;
import dbAccess.RecyclingDAO;
import dbAccess.UserDAO;
import dbAccess.WaterDAO;
import model.Consumption;
import model.Electricity;
import model.Event;
import model.Housing;
import model.Recycling;
import model.User;
import model.Utils;

@Controller
@RequestMapping("/Events")
public class EventController {
	
	ModelAndView model;
	
	EventDAO eventDAO = new EventDAO();
	Event event = new Event();
	
	ConsumptionDAO conDAO = new ConsumptionDAO();
	HousingDAO housingDAO = new HousingDAO();
	UserDAO userDAO = new UserDAO();
	ElectricityDAO electricityDAO = new ElectricityDAO();
	WaterDAO waterDAO = new WaterDAO();
	RecyclingDAO recyclingDAO = new RecyclingDAO();
	
	Utils utils = new Utils();
	
	@RequestMapping("/ViewAll")
	public ModelAndView getAllEvents(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}
		
		User currentUser = userDAO.findUserByName(user.getUsername());
		
		List<Event> eventList = eventDAO.getAll();
		
		model = new ModelAndView("EventsView");
		
		model.addObject("user", currentUser);
		model.addObject("eventList", eventList);
		
		return model;
	}
	
	@RequestMapping("/DataEntry/{eventid}")
	public ModelAndView showDataEntry(HttpServletRequest request, @PathVariable ("eventid") String eventid) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}
		
		User currentUser = userDAO.findUserByName(user.getUsername());
		
		int eventId = Integer.parseInt(eventid);
		
		Event event = eventDAO.findById(eventId);
		Housing housing = housingDAO.checkByEvent(eventId);
		List<Consumption> conList = conDAO.findByHousing(housing.getHousingId());
		
		model = new ModelAndView("DataEntryView");
		
		model.addObject("user", currentUser);
		model.addObject("event", event);
		model.addObject("housing", housing);
		model.addObject("conList", conList);
		
		return model;
	}
	
	@RequestMapping("/Instructions/{eventid}")
	public ModelAndView showInstructions(HttpServletRequest request, @PathVariable ("eventid") String eventid) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		int eventId = Integer.parseInt(eventid);
		
		Event event = eventDAO.findById(eventId);
		
		model = new ModelAndView("InstructionsView");
		
		model.addObject("event", event);
		
		return model;
	}
	
	@RequestMapping("/EventInfo/{eventid}")
	public ModelAndView showEventInfo(HttpServletRequest request, @PathVariable ("eventid") String eventid) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		int eventId = Integer.parseInt(eventid);
		
		model = new ModelAndView("EventInfoView");
		
		Event event = eventDAO.findById(eventId);
		
		String parsedSD = utils.dateToStringParser(event.getStartDate());
		String parsedED = utils.dateToStringParser(event.getEndDate());
		
		model.addObject("event", event);
		model.addObject("parsedSD", parsedSD);
		model.addObject("parsedED", parsedED);
		
		return model;
	}
	
	@RequestMapping("/ProjectImpact/{eventid}")
	public ModelAndView showProjectImpact(HttpServletRequest request, @PathVariable ("eventid") String eventid) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		int eventId = Integer.parseInt(eventid);
		
		Event event = eventDAO.findById(eventId);
		Housing housing = housingDAO.checkByEvent(eventId);
		List<Consumption> conList = conDAO.findByHousing(housing.getHousingId());
		Electricity electricity = electricityDAO.checkByEvent(eventId);
//		List<Recycling> recyclingList = recyclingDAO.getByCon();
		
		
		System.out.print(housing.getHousingId());
		System.out.print(conList);
		
		model = new ModelAndView("ProjectImpactView");
		
		model.addObject("event", event);
		model.addObject("housing", housing);
		model.addObject("con", conList);
		model.addObject("electricity", electricity);
//		model.addObject("recycling", recyclingList);
		
		return model;
	}
}
