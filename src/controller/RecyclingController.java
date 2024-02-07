package controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dbAccess.RecyclingDAO;
import dbAccess.UserDAO;
import model.Electricity;
import model.Recycling;
import model.User;

@Controller
@RequestMapping("/Recycling")
public class RecyclingController {
	
	ModelAndView model;
	
	RecyclingDAO recyclingDAO = new RecyclingDAO();
	Recycling recycling = new Recycling();
	
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
		
		model = new ModelAndView("RecyclingFormView");
		
		model.addObject("user", currentUser);
		model.addObject("eventId", eventId);
		
		try {
			Recycling recycling = recyclingDAO.checkByEvent(eventId);
			
			model.addObject("recycling", recycling);
			
		} catch(EmptyResultDataAccessException e) {
			System.out.println("No data yet. Direct to new form.");
		}
		
		return model;
	}
	
	@RequestMapping(value = "/ShowForm/{eventid}/processingAdd", method = RequestMethod.POST)
	public ModelAndView addRecyclingInfo(HttpServletRequest request, HttpServletResponse response, 
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
//		int conId = Integer.parseInt(request.getParameter("conId"));
		double wasteWeight = Double.parseDouble(request.getParameter("materialWeight"));
		double wasteAmount = Double.parseDouble(request.getParameter("materialAmount"));
		double oilWeight = Double.parseDouble(request.getParameter("oilWeight"));
		double oilAmount = Double.parseDouble(request.getParameter("oilAmount"));
		String image = request.getParameter("image");
		String description = request.getParameter("activityDesc");
		
		recycling.setWasteWeight(wasteWeight);
		recycling.setWasteAmount(wasteAmount);
		recycling.setOilWeight(oilWeight);
		recycling.setOilAmount(oilAmount);
		recycling.setDescription(description);
		recycling.setCarbonValue(wasteWeight, oilWeight);
		
		model = new ModelAndView("RecyclingFormPictureView");
		
		return model;
	}
	
	@RequestMapping(value = "/ShowForm/{eventid}/added", method = RequestMethod.POST)
	public void addRecyclingInfo2(HttpServletRequest request, HttpServletResponse response, 
							      @PathVariable ("eventid") String eventid) throws IOException, ServletException {		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}
		
		User currentUser = userDAO.findUserByName(user.getUsername());
		int eventId = Integer.parseInt(eventid);
		Part filePart = request.getPart("activityPic");
		
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
		
		recycling.setImage(fileName);
		
		recyclingDAO.add(1, recycling);
		
		response.sendRedirect("/EcoNex/Recycling/ShowForm/" + eventId);
	}
	
	@RequestMapping(value = "/ShowForm/{eventid}/processingUpdate", method = RequestMethod.POST)
	public ModelAndView updateRecyclingInfo(HttpServletRequest request, HttpServletResponse response, 
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
		int conId = Integer.parseInt(request.getParameter("conId"));
		double wasteWeight = Double.parseDouble(request.getParameter("materialWeight"));
		double wasteAmount = Double.parseDouble(request.getParameter("materialAmount"));
		double oilWeight = Double.parseDouble(request.getParameter("oilWeight"));
		double oilAmount = Double.parseDouble(request.getParameter("oilAmount"));
		String image = request.getParameter("image");
		String description = request.getParameter("activityDesc");
		
		recycling.setWasteWeight(wasteWeight);
		recycling.setWasteAmount(wasteAmount);
		recycling.setOilWeight(oilWeight);
		recycling.setOilAmount(oilAmount);
		recycling.setDescription(description);
		recycling.setCarbonValue(wasteWeight, oilWeight);
		
		model = new ModelAndView("RecyclingFormPictureView");
		model.addObject("recycling", recycling);
		
		return model;
	}
	
	@RequestMapping(value = "/ShowForm/{eventid}/updated", method = RequestMethod.POST)
	public void updateRecyclingInfo2(HttpServletRequest request, HttpServletResponse response, 
							         @PathVariable ("eventid") String eventid) throws IOException, ServletException {		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}
		
		User currentUser = userDAO.findUserByName(user.getUsername());
		int eventId = Integer.parseInt(eventid);
		
		Part filePart = request.getPart("activityPic");
		
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
		
		recycling.setImage(fileName);
		
		
		recyclingDAO.update(1, recycling);
		
		response.sendRedirect("/EcoNex/Recycling/ShowForm/" + eventId);
	}
	
	@RequestMapping("/ShowForm/{eventid}/deleted")
	public void delete(HttpServletRequest request, HttpServletResponse response,
					   @PathVariable ("eventid") String eventid) throws IOException {
		int recId = Integer.parseInt(request.getParameter("recId"));
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}
		
		User currentUser = userDAO.findUserByName(user.getUsername());
		int eventId = Integer.parseInt(eventid);

		recyclingDAO.delete(recId);
		
		response.sendRedirect("/EcoNex/Recycling/ShowForm/" + eventId);
	}
}
