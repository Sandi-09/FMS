package com.mvc.fraudmanagement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mvc.fraudmanagement.entities.Personnel;

import com.mvc.fraudmanagement.repos.PersonnelRepository;

import com.mvc.fraudmanagement.services.PersonnelService;


@Controller
@SessionAttributes("personnel")
public class PersonnelController {
	
	@Autowired
	private PersonnelService personnelService;
	@Autowired
private PersonnelRepository personnelRepository;
	
	@RequestMapping(value = "/personnel-registration", method = RequestMethod.GET)
	public String showRegistrationPage(ModelMap model){
		model.addAttribute("personnel",new Personnel());
		return "registration-forms/personnel-registration";
	}
	@RequestMapping(value = "/personnel-registration", method = RequestMethod.POST)
	public String saveUserDetails(ModelMap model,@Valid Personnel personnel,BindingResult result) {

		if (result.hasErrors()) {
			return "registration-forms/personnel-registration";
		}
		
		personnelRepository.save(personnel);
		
		return "redirect:/personnel-login";
	}
	
	
	@RequestMapping(value = "/personnel-login",method=RequestMethod.GET)
	public String showLoginPage(){
		return "login-forms/personnel-login";
	}
//	
	@RequestMapping(value = "/personnel-login", method = RequestMethod.POST)
	public String logInUser(ModelMap model,@RequestParam String userId ,@RequestParam String password){
		personnelService.getAllPersonnel();
		boolean isValidUser=personnelService.isValidLogin(userId,password);
		if(!isValidUser) {
			model.put("errorMessage","Invalid User Credentials");
		 return "login-forms/personnel-login";
		}
		Personnel personnel=personnelService.getPersonnelById(userId);
		if(personnel.getIsAuthorized()==0) {
			model.put("errorMessage", "Your Registration Request is Rejected by Admin");
			return "login-forms/personnel-login";
		}
		else if(personnel.getIsAuthorized()==1) {
			model.put("errorMessage","Your Registration is still pending");
			return "login-forms/personnel-login";
		}
			model.put("personnel", personnel);
			return "dashboards/personnel-dashboard";
	}
	
	

}
