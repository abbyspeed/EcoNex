package controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dbAccess.ElectricityDAO;
import model.Electricity;

@Controller
@MultipartConfig
@RequestMapping("/Electricity")
public class ElectricityController {
	
	ModelAndView model;
	
	ElectricityDAO electricityDAO = new ElectricityDAO();
	Electricity electricity = new Electricity();

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
	
	@RequestMapping(value = "/ShowForm/{userid}/{eventid}/processingAdd", method = RequestMethod.POST)
	public ModelAndView addElectricityInfo(HttpServletRequest request, HttpServletResponse response, 
							   @PathVariable ("userid") String userid, @PathVariable ("eventid") String eventid) throws IOException {
		int userId = Integer.parseInt(userid);
		int eventId = Integer.parseInt(eventid);
		int noOfDays = Integer.parseInt(request.getParameter("electricityDays"));
		double profactor = Double.parseDouble(request.getParameter("electricityProrate"));
		int currentUsage = Integer.parseInt(request.getParameter("electricityUsage"));
		double amount = Double.parseDouble(request.getParameter("electricityAmount"));
		String description = request.getParameter("electricityDesc");
		
//		electricity.setConId(userId);
		electricity.setNoOfDays(noOfDays);
		electricity.setProfactor(profactor);
		electricity.setCurrentUsage(currentUsage);
		electricity.setAmount(amount);
		electricity.setDescription(description);
		
		model = new ModelAndView("ElectricityFormPictureView");
		
		return model;
	}
	
	@RequestMapping(value = "/ShowForm/{userid}/{eventid}/added", method = RequestMethod.POST)
	public void addElectricityInfo2(HttpServletRequest request, HttpServletResponse response, 
							   @PathVariable ("userid") String userid, @PathVariable ("eventid") String eventid) throws IOException, ServletException {		
		int userId = Integer.parseInt(userid);
		int eventId = Integer.parseInt(eventid);
		Part filePart = request.getPart("electricityProof");
		
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
		
		InputStream inputStream = null;
		
		if (filePart != null) {
			// prints out some information for debugging
			System.out.println(filePart.getName());
			System.out.println(filePart.getSize());
			System.out.println(filePart.getContentType());
			
			// obtains input stream of the upload file
			inputStream = filePart.getInputStream();
		}
		
		electricity.setBill(fileName);
		
		electricityDAO.add(1, electricity);
		
		response.sendRedirect("/EcoNex/Electricity/ShowForm/" + userId + "/" + eventId);
	}
	
	@RequestMapping(value = "/ShowForm/{userid}/{eventid}/processingUpdate", method = RequestMethod.POST)
	public ModelAndView updateElectricityInfo(HttpServletRequest request, HttpServletResponse response, 
							   @PathVariable ("userid") String userid, @PathVariable ("eventid") String eventid) throws IOException {
		int userId = Integer.parseInt(userid);
		int eventId = Integer.parseInt(eventid);
		int noOfDays = Integer.parseInt(request.getParameter("electricityDays"));
		double profactor = Double.parseDouble(request.getParameter("electricityProrate"));
		int currentUsage = Integer.parseInt(request.getParameter("electricityUsage"));
		double amount = Double.parseDouble(request.getParameter("electricityAmount"));
		String description = request.getParameter("electricityDesc");
		
		electricity.setNoOfDays(noOfDays);
		electricity.setProfactor(profactor);
		electricity.setCurrentUsage(currentUsage);
		electricity.setAmount(amount);
		electricity.setDescription(description);
		
		model = new ModelAndView("ElectricityFormPictureView");
		
		return model;
	}
	
	@RequestMapping(value = "/ShowForm/{userid}/{eventid}/updated", method = RequestMethod.POST)
	public void updateElectricityInfo2(HttpServletRequest request, HttpServletResponse response, 
							   @PathVariable ("userid") String userid, @PathVariable ("eventid") String eventid) throws IOException, ServletException {		
		int userId = Integer.parseInt(userid);
		int eventId = Integer.parseInt(eventid);
		Part filePart = request.getPart("electricityProof");
		
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
		
		InputStream inputStream = null;
		
		if (filePart != null) {
			// prints out some information for debugging
			System.out.println(filePart.getName());
			System.out.println(filePart.getSize());
			System.out.println(filePart.getContentType());
			
			// obtains input stream of the upload file
			inputStream = filePart.getInputStream();
		}
		
		electricity.setBill(fileName);
		
		electricityDAO.add(1, electricity);
		
		response.sendRedirect("/EcoNex/Electricity/ShowForm/" + userId + "/" + eventId);
	}
	
	@RequestMapping(value = "/ShowForm/{userid}/{eventid}/deleted", method = RequestMethod.POST)
	public void deleteHousingInfo(HttpServletRequest request, HttpServletResponse response, 
							   @PathVariable ("userid") String userid, @PathVariable ("eventid") String eventid) throws IOException {
		int userId = Integer.parseInt(userid);
		int eventId = Integer.parseInt(eventid);
		int housingId = Integer.parseInt(request.getParameter("housingId"));
		
		electricityDAO.delete(1);
		
		response.sendRedirect("/EcoNex/Electricity/ShowForm/" + userId + "/" + eventId);
	}
}
