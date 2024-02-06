package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dbAccess.ElectricityDAO;
import model.Electricity;

@Controller
@RequestMapping("/Electricity")
public class ElectricityController {
	
	ModelAndView model;
	
	ElectricityDAO electricityDAO = new ElectricityDAO();

	@RequestMapping("/ShowForm/{userid}/{eventid}")
	public ModelAndView showForm(HttpServletRequest request, @PathVariable ("userid") String userid, @PathVariable ("eventid") String eventid) {
		int userId = Integer.parseInt(userid);
		int eventId = Integer.parseInt(eventid);
		
		model = new ModelAndView("ElectricityFormView");
		
		model.addObject("userId", userId);
		model.addObject("eventId", eventId);
		
		try {
			Electricity electricity = electricityDAO.checkByEvent(eventId);
			
			model.addObject("electricity", electricity);
			
		} catch(EmptyResultDataAccessException e) {
			System.out.println("No data yet. Direct to new form.");
		}
		
		return model;
	}
	
	@RequestMapping(value = "/ShowForm/{userid}/{eventid}/added", method = RequestMethod.POST)
	public void addHousingInfo(HttpServletRequest request, HttpServletResponse response, 
							   @PathVariable ("userid") String userid, @PathVariable ("eventid") String eventid) throws IOException {
		int userId = Integer.parseInt(userid);
		int eventId = Integer.parseInt(eventid);
		String housingArea = request.getParameter("housingArea");
		String housingCategory = request.getParameter("housingCategory");
		String housingName = request.getParameter("housingName");
		int householdNo = Integer.parseInt(request.getParameter("housingHouseholds"));
		String housingAddress = request.getParameter("housingAddress");
		int housingPostcode = Integer.parseInt(request.getParameter("housingPostcode"));
		
		Electricity housing = new Electricity();
		
		electricityDAO.add(housing);
		
		response.sendRedirect("/EcoNex/Housing/ShowForm/" + userId + "/" + eventId);
	}
	
	@RequestMapping(value = "/ShowForm/{userid}/{eventid}/updated", method = RequestMethod.POST)
	public void updateHousingInfo(HttpServletRequest request, HttpServletResponse response, 
							   @PathVariable ("userid") String userid, @PathVariable ("eventid") String eventid) throws IOException {
		int userId = Integer.parseInt(userid);
		int eventId = Integer.parseInt(eventid);
		String housingArea = request.getParameter("housingArea");
		String housingCategory = request.getParameter("housingCategory");
		String housingName = request.getParameter("housingName");
		int householdNo = Integer.parseInt(request.getParameter("housingHouseholds"));
		String housingAddress = request.getParameter("housingAddress");
		int housingPostcode = Integer.parseInt(request.getParameter("housingPostcode"));
		
		Electricity housing = new Electricity();
		
		electricityDAO.update(1, housing);
		
		response.sendRedirect("/EcoNex/Housing/ShowForm/" + userId + "/" + eventId);
	}
	
	@RequestMapping(value = "/ShowForm/{userid}/{eventid}/deleted", method = RequestMethod.POST)
	public void deleteHousingInfo(HttpServletRequest request, HttpServletResponse response, 
							   @PathVariable ("userid") String userid, @PathVariable ("eventid") String eventid) throws IOException {
		int userId = Integer.parseInt(userid);
		int eventId = Integer.parseInt(eventid);
		int housingId = Integer.parseInt(request.getParameter("housingId"));
		
		electricityDAO.delete(1);
		
		response.sendRedirect("/EcoNex/Housing/ShowForm/" + userId + "/" + eventId);
	}
}
