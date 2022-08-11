package com.mvc.fraudmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.support.SessionStatus;


@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String homePage() {
		return "home";
	}
	 @RequestMapping(value = "/log-out", method = RequestMethod.GET)
		public String logOut() {
			return "home";
		}

}
