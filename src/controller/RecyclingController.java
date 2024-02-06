package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dbAccess.RecyclingDAO;
import model.Recycling;

@Controller
@RequestMapping("/Recycling")
public class RecyclingController {
	
	RecyclingDAO recyclingDao = new RecyclingDAO();
	
	@RequestMapping("/GetByID")
	public String getById(HttpServletRequest request, Model model) {
		int recId = Integer.parseInt(request.getParameter("recId"));
		
		Recycling recycling = recyclingDao.findById(recId);
		model.addAttribute("recycling", recycling);
		
		return "";
	}
	
	@RequestMapping("/NewForm")
	public String createNewForm(HttpServletRequest request) {	
		return "RecyclingFormView";
	}
	
	@RequestMapping("/Added")
	public String add(HttpServletRequest request, Model model) {
		int conId = Integer.parseInt(request.getParameter("conId"));
		double wasteWeight = Double.parseDouble(request.getParameter("wasteWeight"));
		double wasteAmount = Double.parseDouble(request.getParameter("wasteAmount"));
		double oilWeight = Double.parseDouble(request.getParameter("oilWeight"));
		double oilAmount = Double.parseDouble(request.getParameter("oilAmount"));
		String image = request.getParameter("image");
		String description = request.getParameter("description");
		
		Recycling recycling = new Recycling();
		recycling.setWasteWeight(wasteWeight);
		recycling.setWasteAmount(wasteAmount);
		recycling.setOilWeight(oilWeight);
		recycling.setOilAmount(oilAmount);
		recycling.setImage(image);
		recycling.setDescription(description);
		
		recyclingDao.add(conId, recycling);
		model.addAttribute("recycling", recycling);
		
		return "";
	}
	
	@RequestMapping("/EditForm")
	public String editForm(HttpServletRequest request, Model model) {
		int recId = Integer.parseInt(request.getParameter("recId"));
		
		Recycling recycling = recyclingDao.findById(recId);
		model.addAttribute(recycling);
		
		return "";
	}
	
	@RequestMapping("/Updated")
	public String update(HttpServletRequest request, Model model) {
		int recId = Integer.parseInt(request.getParameter("recId"));
		double wasteWeight = Double.parseDouble(request.getParameter("wasteWeight"));
		double wasteAmount = Double.parseDouble(request.getParameter("wasteAmount"));
		double oilWeight = Double.parseDouble(request.getParameter("oilWeight"));
		double oilAmount = Double.parseDouble(request.getParameter("oilAmount"));
		String image = request.getParameter("image");
		String description = request.getParameter("description");
		
		Recycling recycling = new Recycling();
		recycling.setWasteWeight(wasteWeight);
		recycling.setWasteAmount(wasteAmount);
		recycling.setOilWeight(oilWeight);
		recycling.setOilAmount(oilAmount);
		recycling.setImage(image);
		recycling.setDescription(description);
		
		recyclingDao.update(recId, recycling);
		model.addAttribute("recycling", recycling);
		
		return "";
	}
	
	@RequestMapping("/Deleted")
	public String delete(HttpServletRequest request) {
		int recId = Integer.parseInt(request.getParameter("recId"));

		recyclingDao.delete(recId);
		
		return "";
	}
}
