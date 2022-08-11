package com.mvc.fraudmanagement.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mvc.fraudmanagement.entities.Card;
//import com.mvc.fraudmanagement.entities.User;
import com.mvc.fraudmanagement.repos.CardRepository;
import com.mvc.fraudmanagement.services.CardService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

@Controller
@SessionAttributes("card")
public class CardController {

	@Autowired
	private CardRepository cardRepository;
	@Autowired
	private CardService cardService;

	@RequestMapping(value = "/card-fraud", method = RequestMethod.GET)
	public String showCard() {
		return "fraud-pages/card-fraud";
	}

	@RequestMapping(value = "/card-registration", method = RequestMethod.GET)
	public String showCardRegistration(ModelMap model) {
		model.addAttribute("card", new Card());
		return "registration-forms/card-registration";
	}

	@RequestMapping(value = "/card-registration", method = RequestMethod.POST)
	public String saveCardRegistration(ModelMap model, @Valid Card card, BindingResult result) {

		if (result.hasErrors()) {
			return "registration-forms/card-registration";
		}

		cardRepository.save(card);

		return "redirect:/card-fraud";
	}

	@RequestMapping(value = "/card-show", method = RequestMethod.GET)
	public String viewAllCard(ModelMap model, @RequestParam String id) {
		List<Card> cardList = cardService.getCardByUserIdList(id);
		if (cardList.size() != 0) {
			model.put("card", cardList);
		} else {
			model.put("errorMessage", "Card does not exist");
		}
		return "dashboards/card-dashboard";
	}

	@RequestMapping(value = "/card-delete", method = RequestMethod.GET)
	public String deleteCard(ModelMap model, @RequestParam String id) {
		Card c = cardService.deleteCard(id);
		cardRepository.delete(c);
		List<Card> cardList = cardService.getCardByUserIdList(id);
		model.put("card", cardList);
		return "dashboards/card-dashboard";
	}

	@RequestMapping(value = "/card-updateForm", method = RequestMethod.GET)
	public String showUpdateCard(ModelMap model, @RequestParam String id) {
		// Card card=cardService.deleteCard(id);
		// cardRepository.delete(card);
		Card card = cardService.getCardByUserId(id);
		model.put("card", card);
		return "pages/card-updateForm";
	}

	@RequestMapping(value = "/card-updateForm", method = RequestMethod.POST)
	public String saveUpdateCard(ModelMap model, @Valid Card card, BindingResult result) {
		List<Card> cardList = cardService.getCardByUserIdList(card.getUserId());
		if (result.hasErrors()) {
			model.put("error", "field cannot be updated");
		}
		cardRepository.save(card);
		model.put("card", cardList);
		return "dashboards/card-dashboard";
	}
	
	@RequestMapping(value="/critical-card",method=RequestMethod.GET)
	public String getCriticalCard(ModelMap model)
	{
		List<Card> card=cardService.getAllCritical();
		if(card.size()!=0)
		{
			model.addAttribute("cardList", card);
		}
		else
		{
			model.addAttribute("msg", "No High Risk Credit/Debit cards Found ");
			return "msg-critical-card";
		}
		return "critical-card";
	}
}