package controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dbAccess.EventDAO;
import dbAccess.HousingDAO;
import model.Event;
import model.Housing;
import model.Utils;

@Controller
@MultipartConfig
@RequestMapping("/Admin")
public class AdminController {
	
	ModelAndView model;
	Utils utils = new Utils();
	
	EventDAO eventDAO = new EventDAO();
	Event event = new Event();
	
	HousingDAO housingDAO = new HousingDAO();
	Housing housing = new Housing();
	
	// PROJECTS
	@RequestMapping("/Projects/ViewAll/{userid}")
	public ModelAndView getAllProjects(HttpServletRequest request) {
//		HttpSession session = request.getSession();
		
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
		
		System.out.print(ongoingList);
		
		model = new ModelAndView("AdminProjectsView");
		
		model.addObject("eventList", eventList);
		model.addObject("upcomingList", upcomingList);
		model.addObject("ongoingList", ongoingList);
		
		return model;
	}
	
	@RequestMapping("/Projects/ProjectForm/{userid}")
	public ModelAndView getProjectForm(@PathVariable ("userid") String userid) {
//		int userId = Integer.parseInt(userid);
		
		int userId = 2;
		
		model = new ModelAndView("AdminProjectFormView");
		
		model.addObject("userId", userId);
		
		return model;
	}
	
	@RequestMapping(value = "/Projects/ProjectForm/{userid}/processing", method = RequestMethod.POST)
	public ModelAndView addProject(HttpServletRequest request, @PathVariable ("userid") String userid) throws ServletException, IOException, ParseException {
		int userId = Integer.parseInt(userid);
		String projectName = request.getParameter("projectName");
		String projectSlogan = request.getParameter("projectSlogan");
		String projectDescription = request.getParameter("projectDescription");
		Date startDate = Date.valueOf(request.getParameter("startDate"));
		Date endDate = Date.valueOf(request.getParameter("endDate"));
		
		event.setUserId(userId);
		event.setName(projectName);
		event.setSlogan(projectSlogan);
		event.setDescription(projectDescription);
		event.setStartDate(startDate);
		event.setEndDate(endDate);
		event.setStatus(startDate, endDate);
			
		model = new ModelAndView("AdminProjectFormPictureView");
		
		return model;
	}
	
	@RequestMapping(value = "/Projects/ProjectForm/{userid}/added", method = RequestMethod.POST)
	public void addProjectPicture(HttpServletRequest request, HttpServletResponse response, 
										  @PathVariable ("userid") String userid) throws ServletException, IOException, ParseException {	
		int userId = Integer.parseInt(userid);
		Part filePart = request.getPart("projectImage");
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
		
		event.setImage(fileName);
		eventDAO.add(event);
		
		response.sendRedirect("/EcoNex/Admin/Projects/ViewAll/" + userId);
	}
	
	
	@RequestMapping("/Projects/ViewProject/{userid}/{eventid}")
	public ModelAndView getProjectInfo(@PathVariable ("userid") String userid, @PathVariable ("eventid") String eventid) {
		int userId = Integer.parseInt(userid);
		int eventId = Integer.parseInt(eventid);
		
		Event event = eventDAO.findById(eventId);
		
		String parsedSD = utils.dateToStringParser(event.getStartDate());
		String parsedED = utils.dateToStringParser(event.getEndDate());
				
		model = new ModelAndView("AdminProjectInfoView");
		
		model.addObject("userId", userId);
		model.addObject("eventId", eventId);
		model.addObject("event", event);
		model.addObject("parsedSD", parsedSD);
		model.addObject("parsedED", parsedED);
		
		return model;
	}
	
	@RequestMapping("/Projects/ViewSubmission/{userid}/{eventid}")
	public ModelAndView getSubmissions(@PathVariable ("userid") String userid, @PathVariable ("eventid") String eventid) {
		int userId = Integer.parseInt(userid);
		int eventId = Integer.parseInt(eventid);
		
		Event event = eventDAO.findById(eventId);
		List<Housing> housingList = housingDAO.getAll();
				
		model = new ModelAndView("AdminSubmissionView");
		
		model.addObject("userId", userId);
		model.addObject("eventId", eventId);
		model.addObject("event", event);
		model.addObject("housingList", housingList);
		
		return model;
	}
	
	// TODO: TO BE EDITED
	@RequestMapping("/Projects/ViewAnalytics/{userid}/{eventid}")
	public ModelAndView getAnalytics(@PathVariable ("userid") String userid, @PathVariable ("eventid") String eventid) {
		int userId = Integer.parseInt(userid);
		int eventId = Integer.parseInt(eventid);
		
		Event event = eventDAO.findById(eventId);
		List<Housing> housingList = housingDAO.getAll();
		
		model = new ModelAndView("AdminAnalyticsView");
		
		model.addObject("userId", userId);
		model.addObject("eventId", eventId);
		model.addObject("event", event);
		model.addObject("housingList", housingList);
		
		return model;
	}
}
