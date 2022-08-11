package com.mvc.fraudmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mvc.fraudmanagement.entities.Claim;
import com.mvc.fraudmanagement.repos.ClaimRepository;
import com.mvc.fraudmanagement.services.ClaimService;

@Controller
@SessionAttributes({"claim","user"})
public class ClaimController {
	
	@Autowired
	ClaimRepository claimRepository;
	@Autowired
	ClaimService claimService;
		

	
	@RequestMapping(value ="/claim-fraud", method = RequestMethod.GET)
	public String showClaim() {
		return "fraud-pages/claim-fraud";
	}
	
	
	
	@RequestMapping(value = "/claim-registration", method = RequestMethod.GET)
	public String showClaimRegistration(ModelMap model) {
		model.addAttribute("claim", new Claim());
		return "registration-forms/claim-registration"; 
	} 
   
    @RequestMapping(value = "/claim-registration", method = RequestMethod.POST)
    public String saveClaimRegistration(ModelMap model, @Valid Claim claim, BindingResult result) {

        if (result.hasErrors()) {
            return "registration-forms/claim-registration";
        }
        claimRepository.save(claim);
        return "redirect:/claim-fraud";  //redirect:/claim-fraud
    }
    
	@RequestMapping(value = "/claim-show", method = RequestMethod.GET)
	public String viewAllClaim(ModelMap model) {
		List<Claim>claimList = claimRepository.findAll();
		if (claimList.size()!=0) {
			model.put("claim", claimList);
		} else {
			model.put("errorMessage", "Claim does not exist");
		}
		return "dashboards/claim-dashboard"; 
	}

        
	@RequestMapping(value = "/claim-delete", method = RequestMethod.GET)
	public String deleteClaim(@RequestParam String userId) {
		Claim claim=claimService.deleteClaim(userId);
		claimRepository.delete(claim);
		return "redirect:/claim-fraud";
	}
	
	
	@RequestMapping(value = "/claim-updateForm", method = RequestMethod.GET)
	public String showUpdateClaim(ModelMap model,@RequestParam String userId) {
//		Claim claim=claimService.deleteClaim(id);
//		claimRepository.delete(claim);
		Claim claim =claimService.getClaimByUserId(userId);
		model.put("claim", claim);
		return "pages/claim-updateForm";
	}
	
	
	@RequestMapping(value = "/claim-updateForm", method = RequestMethod.POST)
	public String saveUpdateClaim(ModelMap model,@Valid Claim  claim,BindingResult result) {
		if(result.hasErrors())
		{
			model.put("error", "field cannot be updated");
		}
		claimRepository.save(claim);
		List<Claim>claimList=claimService.getClaimByUserIdList(claim.getUserId());
		model.put("claim", claimList);
		return "dashboards/claim-dashboard"; 
	}
	
	@RequestMapping(value="/critical-claim",method=RequestMethod.GET)
	public String getCriticalClaim(ModelMap model)
	{
		List<Claim> claim=claimService.getAllCritical();
		if(claim.size()!=0)
		{
			model.addAttribute("claimList", claim);
		}
		else
		{
			model.addAttribute("msg", "No High Risk Critical Claims Found ");
			return "msg-critical-claim";
		}
		return "critical-claim";
		
	}

}
