package controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import model.Electricity;
import model.Recycling;

@Controller
@RequestMapping("/Recycling")
public class RecyclingController {
	
	ModelAndView model;
	
	RecyclingDAO recyclingDAO = new RecyclingDAO();
	Recycling recycling = new Recycling();
	
	@RequestMapping("/ShowForm/{userid}/{eventid}")
	public ModelAndView showForm(HttpServletRequest request, @PathVariable ("userid") String userid, @PathVariable ("eventid") String eventid) {
		int userId = Integer.parseInt(userid);
		int eventId = Integer.parseInt(eventid);
		
		model = new ModelAndView("RecyclingFormView");
		
		model.addObject("userId", userId);
		model.addObject("eventId", eventId);
		
		try {
			Recycling recycling = recyclingDAO.checkByEvent(eventId);
			
			model.addObject("recycling", recycling);
			
		} catch(EmptyResultDataAccessException e) {
			System.out.println("No data yet. Direct to new form.");
		}
		
		return model;
	}
	
	@RequestMapping(value = "/ShowForm/{userid}/{eventid}/processingAdd", method = RequestMethod.POST)
	public ModelAndView addRecyclingInfo(HttpServletRequest request, HttpServletResponse response, 
							   @PathVariable ("userid") String userid, @PathVariable ("eventid") String eventid) throws IOException {
		int userId = Integer.parseInt(userid);
		int eventId = Integer.parseInt(eventid);
		int conId = Integer.parseInt(request.getParameter("conId"));
		double wasteWeight = Double.parseDouble(request.getParameter("wasteWeight"));
		double wasteAmount = Double.parseDouble(request.getParameter("wasteAmount"));
		double oilWeight = Double.parseDouble(request.getParameter("oilWeight"));
		double oilAmount = Double.parseDouble(request.getParameter("oilAmount"));
		String image = request.getParameter("image");
		String description = request.getParameter("description");
		
		recycling.setWasteWeight(wasteWeight);
		recycling.setWasteAmount(wasteAmount);
		recycling.setOilWeight(oilWeight);
		recycling.setOilAmount(oilAmount);
		recycling.setDescription(description);
		
		model = new ModelAndView("RecyclingFormPictureView");
		
		return model;
	}
	
	@RequestMapping(value = "/ShowForm/{userid}/{eventid}/added", method = RequestMethod.POST)
	public void addRecyclingInfo2(HttpServletRequest request, HttpServletResponse response, 
							   @PathVariable ("userid") String userid, @PathVariable ("eventid") String eventid) throws IOException, ServletException {		
		int userId = Integer.parseInt(userid);
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
		
		response.sendRedirect("/EcoNex/Recycling/ShowForm/" + userId + "/" + eventId);
	}
	
	@RequestMapping(value = "/ShowForm/{userid}/{eventid}/processingUpdate", method = RequestMethod.POST)
	public ModelAndView updateRecyclingInfo(HttpServletRequest request, HttpServletResponse response, 
							   @PathVariable ("userid") String userid, @PathVariable ("eventid") String eventid) throws IOException {
		int userId = Integer.parseInt(userid);
		int eventId = Integer.parseInt(eventid);
		int conId = Integer.parseInt(request.getParameter("conId"));
		double wasteWeight = Double.parseDouble(request.getParameter("wasteWeight"));
		double wasteAmount = Double.parseDouble(request.getParameter("wasteAmount"));
		double oilWeight = Double.parseDouble(request.getParameter("oilWeight"));
		double oilAmount = Double.parseDouble(request.getParameter("oilAmount"));
		String image = request.getParameter("image");
		String description = request.getParameter("description");
		
		recycling.setWasteWeight(wasteWeight);
		recycling.setWasteAmount(wasteAmount);
		recycling.setOilWeight(oilWeight);
		recycling.setOilAmount(oilAmount);
		recycling.setDescription(description);
		
		model = new ModelAndView("RecyclingFormPictureView");
		
		return model;
	}
	
	@RequestMapping(value = "/ShowForm/{userid}/{eventid}/updated", method = RequestMethod.POST)
	public void updateRecyclingInfo2(HttpServletRequest request, HttpServletResponse response, 
							   @PathVariable ("userid") String userid, @PathVariable ("eventid") String eventid) throws IOException, ServletException {		
		int userId = Integer.parseInt(userid);
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
		
		response.sendRedirect("/EcoNex/Recycling/ShowForm/" + userId + "/" + eventId);
	}
	
	@RequestMapping("/Deleted")
	public String delete(HttpServletRequest request) {
		int recId = Integer.parseInt(request.getParameter("recId"));

		recyclingDAO.delete(recId);
		
		return "";
	}
}
