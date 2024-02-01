package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Events")
public class EventController {
	
	@RequestMapping("/ViewAll")
	public String getAllEvents(Model model) {
		return "EventsView";
	}
	
	@RequestMapping("/{eventid}/DataEntry")
	public String showDataEntry(@PathVariable ("eventid") int eventid, Model model) {
		return "DataEntryView";
	}
	
	@RequestMapping("/{eventid}/Instructions")
	public String showInstructions(@PathVariable ("eventid") int eventid, Model model) {
		return "InstructionsView";
	}
	
	@RequestMapping("/{eventid}/ProjectImpact")
	public String showProjectImpact(@PathVariable ("eventid") int eventid, Model model) {
		return "ProjectImpactView";
	}
	
	// ADMIN-ONLY PAGES
	@RequestMapping("/{eventid}/Submissions")
	public String showSubmissions(@PathVariable ("eventid") int eventid, Model model) {
		return "AdminSubmissionView";
	}
	
	@RequestMapping("/{eventid}/Analytics")
	public String showAnalytics(@PathVariable ("eventid") int eventid, Model model) {
		return "";
	}
}