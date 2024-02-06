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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dbAccess.ElectricityDAO;
import dbAccess.WaterDAO;
import model.Electricity;
import model.User;
import model.Water;

@Controller
@MultipartConfig
@RequestMapping("/Water")
public class WaterController {
	ModelAndView model;
	
	WaterDAO waterDAO = new WaterDAO();
	Water water = new Water();

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
		
		model = new ModelAndView("WaterFormView");
		
		model.addObject("user", user);
		model.addObject("eventId", eventId);
		
		try {
			Water water = waterDAO.checkByEvent(eventId);
			
			model.addObject("water", water);
			
		} catch(EmptyResultDataAccessException e) {
			System.out.println("No data yet. Direct to new form.");
		}
		
		return model;
	}
	
	@RequestMapping(value = "/ShowForm/{eventid}/processingAdd", method = RequestMethod.POST)
	public ModelAndView addWaterInfo(HttpServletRequest request, HttpServletResponse response, 
							   		 @PathVariable ("eventid") String eventid) throws IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}
		
		int eventId = Integer.parseInt(eventid);
		int noOfDays = Integer.parseInt(request.getParameter("waterDays"));
		double profactor = Double.parseDouble(request.getParameter("waterProrate"));
		int currentUsage = Integer.parseInt(request.getParameter("waterUsage"));
		double amount = Double.parseDouble(request.getParameter("waterAmount"));
		String description = request.getParameter("waterDesc");
		
//		electricity.setConId(userId);
		water.setNoOfDays(noOfDays);
		water.setProfactor(profactor);
		water.setCurrentUsage(currentUsage);
		water.setAmount(amount);
		water.setDescription(description);
		water.setCarbonValue(currentUsage);
		
		model = new ModelAndView("WaterFormPictureView");
		
		return model;
	}
	
	@RequestMapping(value = "/ShowForm/{eventid}/added", method = RequestMethod.POST)
	public void addWaterInfo2(HttpServletRequest request, HttpServletResponse response, 
							  @PathVariable ("eventid") String eventid) throws IOException, ServletException {		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}
		int eventId = Integer.parseInt(eventid);
		Part filePart = request.getPart("waterProof");
		
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
		
		water.setBill(fileName);
		
		waterDAO.add(1, water);
		
		response.sendRedirect("/EcoNex/Water/ShowForm/" + eventId);
	}
	
	@RequestMapping(value = "/ShowForm/{eventid}/processingUpdate", method = RequestMethod.POST)
	public ModelAndView updateWaterInfo(HttpServletRequest request, HttpServletResponse response, 
							   			@PathVariable ("eventid") String eventid) throws IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}
		int eventId = Integer.parseInt(eventid);
		int noOfDays = Integer.parseInt(request.getParameter("waterDays"));
		double profactor = Double.parseDouble(request.getParameter("waterProrate"));
		int currentUsage = Integer.parseInt(request.getParameter("waterUsage"));
		double amount = Double.parseDouble(request.getParameter("waterAmount"));
		String description = request.getParameter("waterDesc");
		
		water.setNoOfDays(noOfDays);
		water.setProfactor(profactor);
		water.setCurrentUsage(currentUsage);
		water.setAmount(amount);
		water.setDescription(description);
		water.setCarbonValue(currentUsage);
		
		model = new ModelAndView("WaterFormPictureView");
		model.addObject("water", water);
		
		return model;
	}
	
	@RequestMapping(value = "/ShowForm/{eventid}/updated", method = RequestMethod.POST)
	public void updateWaterInfo2(HttpServletRequest request, HttpServletResponse response, 
							     @PathVariable ("eventid") String eventid) throws IOException, ServletException {		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}
		int eventId = Integer.parseInt(eventid);
		Part filePart = request.getPart("waterProof");
		
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
		
		water.setBill(fileName);
		
		waterDAO.update(water.getWaterId(), water);
		
		response.sendRedirect("/EcoNex/Water/ShowForm/" + eventId);
	}
	
	@RequestMapping(value = "/ShowForm/{eventid}/deleted", method = RequestMethod.POST)
	public void deleteWaterInfo(HttpServletRequest request, HttpServletResponse response, 
							    @PathVariable ("eventid") String eventid) throws IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}
		int eventId = Integer.parseInt(eventid);
		int housingId = Integer.parseInt(request.getParameter("housingId"));
		
		waterDAO.delete(water.getWaterId());
		
		response.sendRedirect("/EcoNex/Water/ShowForm/" + eventId);
	}
}
