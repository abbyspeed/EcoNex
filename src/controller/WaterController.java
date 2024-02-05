package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import dbAccess.WaterDAO;
import model.Water;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/Water")
public class WaterController {
    private final WaterDAO waterDao = new WaterDAO();

    @RequestMapping("/GetByID")
    public String getById(HttpServletRequest request, Model model) {
        int waterId = Integer.parseInt(request.getParameter("waterId"));

        Water water = waterDao.findById(waterId);
        model.addAttribute("water", water);

        return "WaterInfoView"; 
    }

    @RequestMapping("/NewForm")
    public String createNewForm() {
        return "WaterFormView"; 
    }

    @RequestMapping(value = "/Added", method = RequestMethod.POST)
    public String add(@ModelAttribute("water") Water water, Model model) {
        waterDao.add(water);

        return "redirect:/Water/GetByID?waterId=" + water.getWaterId();
    }

    @RequestMapping("/EditForm")
    public String editForm(HttpServletRequest request, Model model) {
        int waterId = Integer.parseInt(request.getParameter("waterId"));

        Water water = waterDao.findById(waterId);
        model.addAttribute("water", water);

        return "EditWaterFormView"; 
    }

    @RequestMapping(value = "/Updated", method = RequestMethod.POST)
    public String update(@ModelAttribute("water") Water water) {
        waterDao.update(water);

        return "redirect:/Water/GetByID?waterId=" + water.getWaterId();
    }

    @RequestMapping("/Deleted")
    public String delete(HttpServletRequest request) {
        int waterId = Integer.parseInt(request.getParameter("waterId"));

        waterDao.delete(waterId);

        return "redirect:/Water/List"; 
    }

    @RequestMapping("/List")
    public String list(Model model) {
        List<Water> waterList = waterDao.getAll();
        model.addAttribute("waterList", waterList);

        return "WaterList"; 
    }
}
