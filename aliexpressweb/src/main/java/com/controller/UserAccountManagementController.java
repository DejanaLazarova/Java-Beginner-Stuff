package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.model.CreditCard;
import com.model.Product;
import com.model.UserAccount;
import com.service.AccountServiceImplementation;
import com.service.CreditCardServiceImplementation;

@Controller
@RequestMapping("/account")
@SessionAttributes({"card"})
public class UserAccountManagementController {

	private AccountServiceImplementation accountService;
	private CreditCardServiceImplementation creditCardService;

	@Autowired
	public UserAccountManagementController(
			AccountServiceImplementation accountService,
			CreditCardServiceImplementation creditCardService) {
		this.accountService = accountService;
		this.creditCardService = creditCardService;
	}

	// @ModelAttribute
	// public CreditCard card() {
	// return new CreditCard();
	// }

	@ModelAttribute
	public UserAccount useraccount() {
		return new UserAccount();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String createCard(Model model) {
		model.addAttribute("card", new CreditCard());
		return "addaccountcard";
	}

	@RequestMapping(value = "/addcard", method = RequestMethod.POST)
	public String login(@ModelAttribute CreditCard card, Model model,
			BindingResult bindingResult) {
		creditCardService.saveCreditCard(card);
		model.addAttribute("card",card);
		return "redirect:/account/addaccountinfo";
	}

	@RequestMapping(value = "/addaccountinfo", method = RequestMethod.GET)
	public String account(
			@ModelAttribute(value = "account") UserAccount userAccount,
			BindingResult bindingResult, Model model) {
		model.addAttribute("account", userAccount);

		return "addaccountinfo";
	}

	@RequestMapping(value = "/createAccount", method = RequestMethod.POST)
	public String accountInput(
			@ModelAttribute(value = "account") UserAccount userAccount,
			BindingResult bindingResult, HttpSession session) {
		CreditCard card = (CreditCard) session.getAttribute("card");
		userAccount.setCreditCard(card);
		accountService.registerAccount(userAccount);
		return "redirect:/products";
	}

}
