package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dbAccess.ConsumptionDAO;
import dbAccess.HousingDAO;
import dbAccess.UserDAO;
import model.Housing;
import model.User;

@Controller
@RequestMapping("/Housing")
public class HousingController {
	
	ModelAndView model;
	
	HousingDAO housingDAO = new HousingDAO();
	
	ConsumptionDAO conDAO = new ConsumptionDAO();
	UserDAO userDAO = new UserDAO();
	
	@RequestMapping("/ShowForm/{eventid}")
	public ModelAndView showForm(HttpServletRequest request, @PathVariable ("eventid") String eventid) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}
		
		User currentUser = userDAO.findUserByName(user.getUsername());
		int eventId = Integer.parseInt(eventid);
		
		model = new ModelAndView("HousingFormView");
		
		model.addObject("user", currentUser);
		model.addObject("eventId", eventId);
		
		try {
			Housing housing = housingDAO.checkByEvent(eventId);
			
			model.addObject("housing", housing);
			System.out.print(housing.getArea());
			
		} catch(EmptyResultDataAccessException e) {
			System.out.println("No data yet. Direct to new form.");
		}
		
		return model;
	}
	
	@RequestMapping(value = "/ShowForm/{eventid}/added", method = RequestMethod.POST)
	public void addHousingInfo(HttpServletRequest request, HttpServletResponse response, 
							   @PathVariable ("eventid") String eventid) throws IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}
		
		User currentUser = userDAO.findUserByName(user.getUsername());
		
		int eventId = Integer.parseInt(eventid);
		String housingArea = request.getParameter("housingArea");
		String housingCategory = request.getParameter("housingCategory");
		String housingName = request.getParameter("housingName");
		int householdNo = Integer.parseInt(request.getParameter("housingHouseholds"));
		String housingAddress = request.getParameter("housingAddress");
		int housingPostcode = Integer.parseInt(request.getParameter("housingPostcode"));
		
		Housing housing = new Housing();
		housing.setUserId(currentUser.getUserid());
		housing.setEventId(eventId);
		housing.setArea(housingArea);
		housing.setCategory(housingCategory);
		housing.setName(housingName);
		housing.setHouseholdNo(householdNo);
		housing.setAddress(housingAddress);
		housing.setPostcode(housingPostcode);
		
		housingDAO.add(housing);
		
//		conDAO.add(housing.getHousingid(), 1);
		
		response.sendRedirect("/EcoNex/Housing/ShowForm/" + eventId);
	}
	
	@RequestMapping(value = "/ShowForm/{eventid}/updated", method = RequestMethod.POST)
	public void updateHousingInfo(HttpServletRequest request, HttpServletResponse response, 
							      @PathVariable ("eventid") String eventid) throws IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}
		
		User currentUser = userDAO.findUserByName(user.getUsername());
		int eventId = Integer.parseInt(eventid);
		String housingArea = request.getParameter("housingArea");
		String housingCategory = request.getParameter("housingCategory");
		String housingName = request.getParameter("housingName");
		int householdNo = Integer.parseInt(request.getParameter("housingHouseholds"));
		String housingAddress = request.getParameter("housingAddress");
		int housingPostcode = Integer.parseInt(request.getParameter("housingPostcode"));
		
		Housing housing = new Housing();
		housing.setUserId(currentUser.getUserid());
		housing.setEventId(eventId);
		housing.setArea(housingArea);
		housing.setCategory(housingCategory);
		housing.setName(housingName);
		housing.setHouseholdNo(householdNo);
		housing.setAddress(housingAddress);
		housing.setPostcode(housingPostcode);
		
		housingDAO.update(1, housing);
		
		response.sendRedirect("/EcoNex/Housing/ShowForm/" + eventId);
	}
	
	@RequestMapping(value = "/ShowForm/{eventid}/deleted")
	public void deleteHousingInfo(HttpServletRequest request, HttpServletResponse response, 
							      @PathVariable ("eventid") String eventid) throws IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}
		
		User currentUser = userDAO.findUserByName(user.getUsername());
		
		int eventId = Integer.parseInt(eventid);
//		int housingId = Integer.parseInt(request.getParameter("housingId"));
		
		housingDAO.delete(1);
		
		response.sendRedirect("/EcoNex/Housing/ShowForm/" + eventId);
	}
}
