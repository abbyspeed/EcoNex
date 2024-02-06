package controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dbAccess.ElectricityDAO;
import model.Electricity;
import model.User;

@Controller
@MultipartConfig
@RequestMapping("/Electricity")
public class ElectricityController {
	
	ModelAndView model;
	
	ElectricityDAO electricityDAO = new ElectricityDAO();
	Electricity electricity = new Electricity();

	@RequestMapping("/ShowForm/{eventid}")
	public ModelAndView showForm(HttpServletRequest request, @PathVariable ("eventid") String eventid) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}
		
		int eventId = Integer.parseInt(eventid);
		
		model = new ModelAndView("ElectricityFormView");
		
		model.addObject("user", user);
		model.addObject("eventId", eventId);
		
		try {
			Electricity electricity = electricityDAO.checkByEvent(eventId);
			
			model.addObject("electricity", electricity);
			
		} catch(EmptyResultDataAccessException e) {
			System.out.println("No data yet. Direct to new form.");
		}
		
		return model;
	}
	
	@RequestMapping(value = "/ShowForm/{eventid}/processingAdd", method = RequestMethod.POST)
	public ModelAndView addElectricityInfo(HttpServletRequest request, HttpServletResponse response, 
							   			   @PathVariable ("eventid") String eventid) throws IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}
		
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
		electricity.setCarbonValue(currentUsage);
		
		model = new ModelAndView("ElectricityFormPictureView");
		
		model.addObject("eventId", eventId);
		
		return model;
	}
	
	@RequestMapping(value = "/ShowForm/{eventid}/added", method = RequestMethod.POST)
	public void addElectricityInfo2(HttpServletRequest request, HttpServletResponse response, 
							   		@PathVariable ("eventid") String eventid, Model model) throws IOException, ServletException {		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}
		
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
		
		model.addAttribute("eventId", eventId);
		
		response.sendRedirect("/EcoNex/Electricity/ShowForm/" + eventId);
	}
	
	@RequestMapping(value = "/ShowForm/{eventid}/processingUpdate", method = RequestMethod.POST)
	public ModelAndView updateElectricityInfo(HttpServletRequest request, HttpServletResponse response, 
							   				  @PathVariable ("eventid") String eventid) throws IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}
		
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
		electricity.setCarbonValue(currentUsage);
		
		model = new ModelAndView("ElectricityFormPictureView");
		
		model.addObject("eventId", eventId);
		
		return model;
	}
	
	@RequestMapping(value = "/ShowForm/{eventid}/updated", method = RequestMethod.POST)
	public void updateElectricityInfo2(HttpServletRequest request, HttpServletResponse response, 
							   		   @PathVariable ("eventid") String eventid, Model model) throws IOException, ServletException {		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}
		
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
		
		model.addAttribute("eventId", eventId);
		
		response.sendRedirect("/EcoNex/Electricity/ShowForm/" + eventId);
	}
	
	@RequestMapping(value = "/ShowForm/{eventid}/deleted", method = RequestMethod.POST)
	public void deleteElectricityInfo(HttpServletRequest request, HttpServletResponse response, 
							   	  @PathVariable ("eventid") String eventid, Model model) throws IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}
		int eventId = Integer.parseInt(eventid);
		int housingId = Integer.parseInt(request.getParameter("housingId"));
		
		electricityDAO.delete(1);
		
		model.addAttribute("eventId", eventId);
		
		response.sendRedirect("/EcoNex/Electricity/ShowForm/" + eventId);
	}
}
