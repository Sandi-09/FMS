package com.mvc.fraudmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mvc.fraudmanagement.entities.Card;
import com.mvc.fraudmanagement.entities.Claim;
import com.mvc.fraudmanagement.entities.Transaction;
import com.mvc.fraudmanagement.repos.CardRepository;
import com.mvc.fraudmanagement.repos.ClaimRepository;
import com.mvc.fraudmanagement.repos.TransactionRepository;
import com.mvc.fraudmanagement.services.CardService;

@Controller
@SessionAttributes({"admin","unApprovedFraudPersonnel","unApprovedUser"})
public class ManageFraudController {

	@Autowired
	CardRepository cardRepository;
	@Autowired
	CardService cardService;
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	ClaimRepository claimRepository;

	
	@RequestMapping(value="/manage-fraud",method=RequestMethod.GET)
	public String manageFraud() {
		return "fraud-pages/manage-all-fraud";	
	}
	
	@RequestMapping(value="/all-card-fraud",method=RequestMethod.GET)
	public String allCardFraud(ModelMap model){
		
		List<Card> card=cardRepository.findAll();
		
		if(card.size()==0){
		model.addAttribute("msg", "No records found");
		return  "msg-all-card-fraud";
		}
		else{
		model.addAttribute("cardList",card);
		return "all-card-fraud";
		}
}
	
	
	@RequestMapping(value="/all-transaction-fraud",method=RequestMethod.GET)
	public String allTransactionFraud(ModelMap model){
		
		List<Transaction> transaction=transactionRepository.findAll();
		if(transaction.size()==0){
			
			model.addAttribute("msg", "No records found");
			return  "msg-all-transaction-fraud";
		}
	
	else{
		model.addAttribute("transList", transaction);
		return "all-transaction-fraud";
	}
	}
	

	@RequestMapping(value="/all-claim-fraud",method=RequestMethod.GET)
	public String allClaimFraud(ModelMap model){
		
		List<Claim> claim=claimRepository.findAll();
		if(claim.size()==0){
			
				model.addAttribute("msg", "No records found");
				return  "msg-all-claim-fraud";
			}
		
		else{
			model.addAttribute("claimList", claim);
			return "all-claim-fraud";
		}
	}

}
