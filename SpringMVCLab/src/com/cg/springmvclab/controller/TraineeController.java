package com.cg.springmvclab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cg.springmvclab.dto.Trainee;
import com.cg.springmvclab.service.TraineeService;

@Controller
public class TraineeController {

	static Trainee traineeOne;
	@Autowired
	TraineeService service;
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showHomePage() {		
		return "index";		
	}
	@RequestMapping(value="/showOptions", method=RequestMethod.GET)
	public String login() {		
		return "login";		
	}
	@RequestMapping(value="/Options", method=RequestMethod.POST)
	public String afterLogin() {		
		return "options";		
	}
	
	@RequestMapping(value="/addtrainee",method=RequestMethod.GET)
	public String showAddTrainer(@ModelAttribute("trn") Trainee trainee) {
		return "AddTrainee";
	}
	@RequestMapping(value="/added", method=RequestMethod.POST)
	public String addTrainee(@ModelAttribute("trn") Trainee trainee) {
		service.addTrainee(trainee);
		return "options";		
	}
	@RequestMapping(value = "/deletetrainee", method = RequestMethod.GET)
	public String showDeleteTrainee(@ModelAttribute("trn") Trainee trainee) {
		return "DeleteTrainee";
	}
	@RequestMapping(value="/deleted", method = RequestMethod.POST)
	public ModelAndView delete(@ModelAttribute("trn") Trainee trainee) {
		traineeOne = service.showTrainee(trainee.getTraineeId());
		return new ModelAndView("DeleteTrainee", "data", traineeOne);
	}
	@RequestMapping(value="/actualdelete", method=RequestMethod.POST)
	public String actualDelete() {
		service.deleteTrainee(traineeOne.getTraineeId());
		return "options";
		
	}
}
