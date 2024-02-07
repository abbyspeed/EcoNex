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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
import model.Water;

@Controller
@MultipartConfig
@RequestMapping("/Admin")
public class AdminController {

	ModelAndView model;
	Utils utils = new Utils();
	
	UserDAO userDAO = new UserDAO();
	
	EventDAO eventDAO = new EventDAO();
	Event event = new Event();

	HousingDAO housingDAO = new HousingDAO();
	ConsumptionDAO consumptionDAO = new ConsumptionDAO();
	Housing housing = new Housing();

	ElectricityDAO electricityDAO = new ElectricityDAO();
	Electricity electricity = new Electricity();
	
	RecyclingDAO recDAO = new RecyclingDAO();
	
	WaterDAO watDAO = new WaterDAO();

	// DASHBOARD
	@RequestMapping("/Dashboard")
	public ModelAndView getDashboard(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}
		
		User currentUser = userDAO.findUserByName(user.getUsername());
		
		List<Event> eventList = eventDAO.getAll();
		
		model = new ModelAndView("AdminDashboardView");
		
		model.addObject("user", currentUser);
		model.addObject("eventList", eventList);
		
		return model;
	}

	// SETTINGS
	@RequestMapping("/Settings")
	public ModelAndView getSettings(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
		if (user == null) {
			return new ModelAndView("redirect:/Login");
		}

		// get user by id
		UserDAO udao = new UserDAO();
		User foundUser = udao.findUserByName(user.getUsername());

		if ("admin".equals(user.getRole())) {
			return new ModelAndView("AdminProfileSettingsView").addObject("initUser", foundUser);
		}

		return new ModelAndView("ProfileSettingsView").addObject("initUser", foundUser);
	}

	// PROJECTS
	@RequestMapping("/Projects/ViewAll")
	public ModelAndView getAllProjects(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}

		List<Event> eventList = eventDAO.getAll();
		
		model = new ModelAndView("AdminProjectsView");

		model.addObject("eventList", eventList);
		model.addObject("user", user);
		
		return model;
	}

	@RequestMapping("/Projects/ProjectForm")
	public ModelAndView getProjectForm(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}

		model = new ModelAndView("AdminProjectFormView");

		model.addObject("userId", user.getUserid());

		return model;
	}

	@RequestMapping(value = "/Projects/ProjectForm/processing", method = RequestMethod.POST)
	public ModelAndView addProject(HttpServletRequest request) throws ServletException, IOException, ParseException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}

		String projectName = request.getParameter("projectName");
		String projectSlogan = request.getParameter("projectSlogan");
		String projectDescription = request.getParameter("projectDescription");
		Date startDate = Date.valueOf(request.getParameter("startDate"));
		Date endDate = Date.valueOf(request.getParameter("endDate"));

		event.setUserId(user.getUserid());
		event.setName(projectName);
		event.setSlogan(projectSlogan);
		event.setDescription(projectDescription);
		event.setStartDate(startDate);
		event.setEndDate(endDate);
		event.setStatus(startDate, endDate);

		model = new ModelAndView("AdminProjectFormPictureView");

		return model;
	}

	@RequestMapping(value = "/Projects/ProjectForm/added", method = RequestMethod.POST)
	public void addProjectPicture(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			response.sendRedirect("redirect:/Login");
//		}

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
		
		response.sendRedirect("/EcoNex/Admin/Projects/ViewAll/");
	}

	@RequestMapping("/Projects/ViewProject/{eventid}")
	public ModelAndView getProjectInfo(HttpServletRequest request, @PathVariable("eventid") String eventid) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}

		int eventId = Integer.parseInt(eventid);

		Event event = eventDAO.findById(eventId);

		String parsedSD = utils.dateToStringParser(event.getStartDate());
		String parsedED = utils.dateToStringParser(event.getEndDate());

		model = new ModelAndView("AdminProjectInfoView");

		model.addObject("user", user);
		model.addObject("eventId", eventId);
		model.addObject("event", event);
		model.addObject("parsedSD", parsedSD);
		model.addObject("parsedED", parsedED);

		return model;
	}

	@RequestMapping("/Projects/ViewSubmission/{eventid}")
	public ModelAndView getSubmissions(HttpServletRequest request, @PathVariable("eventid") String eventid) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}

		int eventId = Integer.parseInt(eventid);

		Event event = eventDAO.findById(eventId);
		List<Housing> housingList = housingDAO.getAll();

		model = new ModelAndView("AdminSubmissionView");

		model.addObject("user", user);
		model.addObject("eventId", eventId);
		model.addObject("event", event);
		model.addObject("housingList", housingList);

		return model;
	}

	// HOUSING
	@RequestMapping("/Projects/ViewSubmission/{eventid}/Housing/ShowForm")
	public ModelAndView showHousingForm(HttpServletRequest request, @PathVariable("eventid") String eventid) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}

		int eventId = Integer.parseInt(eventid);
		int participantId = Integer.parseInt(request.getParameter("userId"));

		Event event = eventDAO.findById(eventId);
		List<Housing> housingList = housingDAO.getAll();

		model = new ModelAndView("AdminHousingForm");

		model.addObject("user", user);
		model.addObject("eventId", eventId);
		model.addObject("event", event);
		model.addObject("housingList", housingList);

		return model;
	}

	@RequestMapping(value = "/Projects/ViewSubmission/{eventid}/Housing/ShowForm/added", method = RequestMethod.POST)
	public void addHousingInfo(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("eventid") String eventid) throws IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}

		int eventId = Integer.parseInt(eventid);
		int participantId = Integer.parseInt(request.getParameter("participantId"));
		String housingArea = request.getParameter("housingArea");
		String housingCategory = request.getParameter("housingCategory");
		String housingName = request.getParameter("housingName");
		int householdNo = Integer.parseInt(request.getParameter("housingHouseholds"));
		String housingAddress = request.getParameter("housingAddress");
		int housingPostcode = Integer.parseInt(request.getParameter("housingPostcode"));

		Housing housing = new Housing();
		housing.setUserId(participantId);
		housing.setEventId(eventId);
		housing.setArea(housingArea);
		housing.setCategory(housingCategory);
		housing.setName(housingName);
		housing.setHouseholdNo(householdNo);
		housing.setAddress(housingAddress);
		housing.setPostcode(housingPostcode);

		housingDAO.add(housing);

//		conDAO.add(housing.getHousingid(), 1);

		response.sendRedirect("/EcoNex/Admin//Projects/ViewSubmission/" + eventid + "/Housing/ShowForm");
	}

	@RequestMapping(value = "/Projects/ViewSubmission/{eventid}/Housing/ShowForm/updated", method = RequestMethod.POST)
	public void updateHousingInfo(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("eventid") String eventid) throws IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}

		int eventId = Integer.parseInt(eventid);
		int participantId = Integer.parseInt(request.getParameter("participantId"));
		String housingArea = request.getParameter("housingArea");
		String housingCategory = request.getParameter("housingCategory");
		String housingName = request.getParameter("housingName");
		int householdNo = Integer.parseInt(request.getParameter("housingHouseholds"));
		String housingAddress = request.getParameter("housingAddress");
		int housingPostcode = Integer.parseInt(request.getParameter("housingPostcode"));

		Housing housing = new Housing();
		housing.setUserId(participantId);
		housing.setEventId(eventId);
		housing.setArea(housingArea);
		housing.setCategory(housingCategory);
		housing.setName(housingName);
		housing.setHouseholdNo(householdNo);
		housing.setAddress(housingAddress);
		housing.setPostcode(housingPostcode);

		housingDAO.update(1, housing);

		response.sendRedirect("/EcoNex/Admin//Projects/ViewSubmission/" + eventid + "/Housing/ShowForm");
	}

	@RequestMapping(value = "/Projects/ViewSubmission/{eventid}/Housing/ShowForm/deleted")
	public void deleteHousingInfo(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("eventid") String eventid) throws IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}

		int eventId = Integer.parseInt(eventid);
		int participantId = Integer.parseInt(request.getParameter("participantId"));
//		int housingId = Integer.parseInt(request.getParameter("housingId"));

		housingDAO.delete(1);

		response.sendRedirect("/EcoNex/Admin//Projects/ViewSubmission/" + eventid + "/Housing/ShowForm");
	}

	// ELECTRICITY
	@RequestMapping("/Projects/ViewSubmission/{eventid}/Electricity/ShowForm")
	public ModelAndView showForm(HttpServletRequest request, @PathVariable("eventid") String eventid) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}

		int eventId = Integer.parseInt(eventid);

		model = new ModelAndView("AdminElectricityFormView");

		model.addObject("user", user);
		model.addObject("eventId", eventId);

		try {
			Electricity electricity = electricityDAO.checkByEvent(eventId);

			model.addObject("electricity", electricity);

		} catch (EmptyResultDataAccessException e) {
			System.out.println("No data yet. Direct to new form.");
		}

		return model;
	}

	@RequestMapping(value = "/Projects/ViewSubmission/{eventid}/Electricity/ShowForm/processingAdd", method = RequestMethod.POST)
	public ModelAndView addElectricityInfo(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("eventid") String eventid) throws IOException {
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

		model = new ModelAndView("AdminElectricityFormPictureView");

		return model;
	}

	@RequestMapping(value = "/Projects/ViewSubmission/{eventid}/Electricity/ShowForm/added", method = RequestMethod.POST)
	public void addElectricityInfo2(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("eventid") String eventid) throws IOException, ServletException {
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

		response.sendRedirect("/EcoNex/Electricity/ShowForm/" + eventId);
	}

	@RequestMapping(value = "/Projects/ViewSubmission/{eventid}/Electricity/ShowForm/processingUpdate", method = RequestMethod.POST)
	public ModelAndView updateElectricityInfo(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("eventid") String eventid) throws IOException {
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

		model = new ModelAndView("AdminElectricityFormPictureView");

		return model;
	}

	@RequestMapping(value = "/Projects/ViewSubmission/{eventid}/Electricity/ShowForm/updated", method = RequestMethod.POST)
	public void updateElectricityInfo2(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("eventid") String eventid) throws IOException, ServletException {
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

		response.sendRedirect("/EcoNex/Electricity/ShowForm/" + eventId);
	}

	@RequestMapping(value = "/Projects/ViewSubmission/{eventid}/Electricity/ShowForm/deleted", method = RequestMethod.POST)
	public void deleteElectricityInfo(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("eventid") String eventid) throws IOException {
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

		response.sendRedirect("/EcoNex/Electricity/ShowForm/" + eventId);
	}

	// WATER

	// TODO: TO BE EDITED
	@RequestMapping("/Projects/ViewAnalytics/{eventid}")
	public ModelAndView getAnalytics(HttpServletRequest request, @PathVariable("eventid") String eventid) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// not logged in
//		if (user == null) {
//			redirectAttrs.addFlashAttribute("error", "Login First");
//			return new ModelAndView("redirect:/Login");
//		}

		int eventId = Integer.parseInt(eventid);

		Event event = eventDAO.findById(eventId);
		List<Housing> housingList = housingDAO.getAll();
		
		//find Housing by eventid
		Housing house = housingDAO.findByEventId(eventId);
		
		//find consumption by housing id
		Consumption con = consumptionDAO.findByHousing(house.getHousingId());
		
		//find electricity by consumption id
		Electricity electricity = electricityDAO.findByConId(con.getConid());
		
		//find recycling by conid
		Recycling rec = recDAO.findByConId(con.getConid());
		
		//find water by conid
		Water water = watDAO.findByConId(con.getConid());

		model = new ModelAndView("AdminAnalyticsView");

		model.addObject("user", user);
		model.addObject("eventId", eventId);
		model.addObject("event", event);
		model.addObject("housingList", housingList);
		model.addObject("water", water);
		model.addObject("rec", rec);
		model.addObject("elec", electricity);

		return model;
	}
}
