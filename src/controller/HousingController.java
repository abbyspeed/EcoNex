package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dbAccess.HousingDAO;
import model.Housing;

@Controller
@RequestMapping("/Housing")
public class HousingController {
	
	ModelAndView model;
	
	HousingDAO housingDAO = new HousingDAO();
	
	@RequestMapping("/ShowForm/{userid}/{eventid}")
	public ModelAndView showForm(HttpServletRequest request, @PathVariable ("userid") String userid, @PathVariable ("eventid") String eventid) {
		int userId = Integer.parseInt(userid);
		int eventId = Integer.parseInt(eventid);
		
		model = new ModelAndView("HousingFormView");
		
		model.addObject("userId", userId);
		model.addObject("eventId", eventId);
		
		try {
			Housing housing = housingDAO.checkByEvent(eventId);
			
			model.addObject("housing", housing);
			
		} catch(EmptyResultDataAccessException e) {
			System.out.println("No data yet. Direct to new form.");
		}
		
		return model;
	}
	
	@RequestMapping(value = "/{userid}/{eventid}/added", method = RequestMethod.POST)
	public void addHousingInfo(HttpServletRequest request, HttpServletResponse response, 
							   @PathVariable ("userid") String userid, @PathVariable ("eventid") String eventid) throws IOException {
		int userId = Integer.parseInt(userid);
		int eventId = Integer.parseInt(eventid);
		String housingArea = request.getParameter("housingArea");
		String housingCategory = request.getParameter("housingCategory");
		String housingName = request.getParameter("housingName");
		int householdNo = Integer.parseInt(request.getParameter("housingHouseholds"));
		String housingAddress1 = request.getParameter("housingAddress1");
		String housingAddress2 = request.getParameter("housingAddress2");
		int housingPostcode = Integer.parseInt(request.getParameter("housingPostcode"));
		
		Housing housing = new Housing();
		housing.setUserId(userId);
		housing.setEventId(eventId);
		housing.setArea(housingArea);
		housing.setCategory(housingCategory);
		housing.setName(housingName);
		housing.setHouseholdNo(householdNo);
		housing.setAddress(housingAddress1 + " " + housingAddress2);
		housing.setPostcode(housingPostcode);
		
		housingDAO.add(housing);
		
		response.sendRedirect("/EcoNex/Housing/ShowForm/" + userId + "/" + eventId);
	}
	
	@RequestMapping(value = "/{userid}/{eventid}/updated", method = RequestMethod.POST)
	public void updateHousingInfo(HttpServletRequest request, HttpServletResponse response, 
							   @PathVariable ("userid") String userid, @PathVariable ("eventid") String eventid) throws IOException {
		int userId = Integer.parseInt(userid);
		int eventId = Integer.parseInt(eventid);
		String housingArea = request.getParameter("housingArea");
		String housingCategory = request.getParameter("housingCategory");
		String housingName = request.getParameter("housingName");
		int householdNo = Integer.parseInt(request.getParameter("housingHouseholds"));
		String housingAddress1 = request.getParameter("housingAddress1");
		String housingAddress2 = request.getParameter("housingAddress2");
		int housingPostcode = Integer.parseInt(request.getParameter("housingPostcode"));
		
		Housing housing = new Housing();
		housing.setUserId(userId);
		housing.setEventId(eventId);
		housing.setArea(housingArea);
		housing.setCategory(housingCategory);
		housing.setName(housingName);
		housing.setHouseholdNo(householdNo);
		housing.setAddress(housingAddress1 + " " + housingAddress2);
		housing.setPostcode(housingPostcode);
		
		housingDAO.update(housing);
		
		response.sendRedirect("/EcoNex/Housing/ShowForm/" + userId + "/" + eventId);
	}
}
