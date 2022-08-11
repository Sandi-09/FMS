package com.mvc.fraudmanagement.controller;

import javax.validation.Valid;

//import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mvc.fraudmanagement.entities.User;
import com.mvc.fraudmanagement.repos.UserRepository;
import com.mvc.fraudmanagement.services.UserService;

@Controller
@SessionAttributes("user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
    private UserRepository userRepository;
	
	@RequestMapping(value = "/user-registration", method = RequestMethod.GET)
	public String showRegistrationPage(ModelMap model){
		model.addAttribute("user",new User());
		return "registration-forms/UserRegistration";
	}
	@RequestMapping(value = "/user-registration", method = RequestMethod.POST)
	public String saveUserDetails(ModelMap model,@Valid User user,BindingResult result) {

		if (result.hasErrors()) {
			return "registration-forms/UserRegistration";
		}
		
		userRepository.save(user);
		
		return "redirect:/Userlogin";
	}
	
	
	@RequestMapping(value = "/Userlogin",method=RequestMethod.GET)
	public String showLoginPage(){
		return "login-forms/Userlogin";
	}
//	
	@RequestMapping(value = "/Userlogin", method = RequestMethod.POST)
	public String logInUser(ModelMap model,@RequestParam String userId ,@RequestParam String password){
		userService.getAllUser();
		boolean isValidUser=userService.isValidLogin(userId,password);
		if(!isValidUser) {
			model.put("errorMessage","Invalid User Credentials");
		 return "login-forms/Userlogin";
		}
		User user=userService.getUserById(userId);
		if(user.getIsAuthorized()==0) {
			model.put("errorMessage", "Your Registration Request is Rejected by Admin");
			return "login-forms/Userlogin";
		}
		else if(user.getIsAuthorized()==1) {
			model.put("errorMessage","Your Registration is still pending");
			return "login-forms/Userlogin";
		}
			model.put("user", user);
			return "dashboards/fraud-analyzer-dashboard";
	}


	

	@RequestMapping(value = "/fraudAnalyzer", method = RequestMethod.GET)
	public String fraudAnalyzerPage(){
		return "fraudAnalyser";
	}
	

//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String show(){
//		return "welcome to my page";
//	}
	
}
