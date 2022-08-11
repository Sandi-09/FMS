package com.mvc.fraudmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.support.SessionStatus;

import com.mvc.fraudmanagement.entities.Admin;
import com.mvc.fraudmanagement.services.AdminService;
import com.mvc.fraudmanagement.services.PersonnelService;
import com.mvc.fraudmanagement.services.UserService;
import com.mvc.fraudmanagement.entities.Personnel;
import com.mvc.fraudmanagement.entities.User;

@Controller
@SessionAttributes({"admin","unApprovedFraudPersonnel","unApprovedUser"})
public class AdminController {
	
	@Autowired
	private PersonnelService personnelService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="/admin-login", method = RequestMethod.GET)
	public String showAdminLoginPage() {
		return "login-forms/admin-login";
	}
	
	@RequestMapping(value="/admin-login", method = RequestMethod.POST)
	public String showAdminDashboardPage(ModelMap model, @RequestParam String userId, @RequestParam String password){
		adminService.loadAdmin();
		
		boolean isValidAdmin = adminService.validateAdmin(userId, password);
		
		if (!isValidAdmin) {
			model.put("errorMessage", "Invalid Credentials");
			return "login-forms/admin-login";
		}
		
		model.put("admin", new Admin(userId,password));
		
		return "dashboards/admin-dashboard";
	}
	
	@RequestMapping(value = "/pending-requests", method = RequestMethod.GET)
	public String showPendingRegistrationRequestsPage(ModelMap model) {
		
		List<Personnel> unApprovedPersonnel = personnelService.getUnApprovedPersonnel();
		List<User> unApprovedUser = userService.getUnApprovedUser();
		
		model.put("unApprovedPersonnel", unApprovedPersonnel);
		model.put("unApprovedUser", unApprovedUser);
		
		return "pages/pending-registration-request";
	}
	
	@RequestMapping(value = "/approve-user", method = RequestMethod.GET)
	public String approveUserRegistrationRequest(ModelMap model, @RequestParam int id) {
		userService.approveUser(id);
		List<User> unApprovedUser = userService.getUnApprovedUser();
		
		if(unApprovedUser.size()==0) {
			model.put("emptyList1", "Currently No Requests to Show");
		}
		else	
			model.put("unApprovedUser", unApprovedUser);
		return "pages/pending-registration-request";
	}
	
	@RequestMapping(value = "/reject-user", method = RequestMethod.GET)
	public String rejectUserRegistrationRequest(ModelMap model, @RequestParam int id) {
		userService.rejectUser(id);
		List<User> unApprovedUser = userService.getUnApprovedUser();
		model.put("unApprovedUser", unApprovedUser);
		return "pages/pending-registration-request";
	}
	
	@RequestMapping(value = "/approve-personnel", method = RequestMethod.GET)
	public String approvePersonnelRegistrationRequest(ModelMap model, @RequestParam int id) {
		personnelService.approvePersonnel(id);
		List<Personnel> unApprovedPersonnel = personnelService.getUnApprovedPersonnel();
		
		if(unApprovedPersonnel.size()==0) {
			model.put("emptyList2", "Currently No Requests to Show");
		}
		else	
			model.put("unApprovedPersonnel", unApprovedPersonnel);
		return "pages/pending-registration-request";
	}
	
	@RequestMapping(value = "/reject-personnel", method = RequestMethod.GET)
	public String rejectPersonnelRegistrationRequest(ModelMap model, @RequestParam int id) {
		personnelService.rejectPersonnel(id);
		List<Personnel> unApprovedPersonnel = personnelService.getUnApprovedPersonnel();
		model.put("unApprovedPersonnel", unApprovedPersonnel);
		return "pages/pending-registration-request";
	}
	
	@RequestMapping(value="/admin-dashboard", method = RequestMethod.GET)
	public String showAdminDashboardPage() {
		return "dashboards/admin-dashboard";
	}
	
//	 @RequestMapping(value = "/log-out", method = RequestMethod.GET)
//		public String logOutOfficer(SessionStatus sessionStatus) {
//			sessionStatus.setComplete();
//			return "home";
//		}
}

