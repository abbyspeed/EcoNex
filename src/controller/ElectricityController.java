package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dbAccess.ElectricityDAO;

@Controller
@RequestMapping("/Electricity")
public class ElectricityController {

	ElectricityDAO electricityDAO = new ElectricityDAO();
}
