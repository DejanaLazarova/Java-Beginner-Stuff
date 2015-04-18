package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.model.Product;
import com.model.UserAccount;
import com.service.AccountServiceImplementation;
import com.service.ShoppingCartServiceImplementation;
import com.shoppingcart.ShoppingCartImplementation;
import com.shoppingcart.ShoppingCartItem;

@Controller
@RequestMapping("/cart")
@SessionAttributes({ "cart" })
public class ShoppingCartManagementController {

	ShoppingCartServiceImplementation service;
	AccountServiceImplementation account;
	//List<ShoppingCartItem> cart;
	//ShoppingCartImplementation cart;

	@Autowired
	public ShoppingCartManagementController(
			ShoppingCartServiceImplementation service,
			AccountServiceImplementation account) {
		this.service = service;
		this.account = account;
		//this.cart = new ArrayList<ShoppingCartItem>();
	}

	@ModelAttribute
	public Product product() {
		return new Product();
		
	}

//	@ModelAttribute
//	public UserAccount UserAccount() {
//		return new UserAccount();
//	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getProduct(@PathVariable("id") int id, Model model, HttpSession session) {
		Product product = service.getProductById(id);
		service.insertProductAndQuantity(product.getProductName(),product.getProductQuantity());
		int sum = service.sumTotalPayment();
		model.addAttribute("sum",sum);
		session.setAttribute("sum", sum);
		return "cart";								
	}

	@ModelAttribute("cart")
	public List<ShoppingCartItem> getProductsInCart() {	
		return service.showProductsInCart();	
	}

	@RequestMapping(value="/payment" , method = RequestMethod.GET)
	public String getInfo(Model model) {
		model.addAttribute("useraccount", new UserAccount());
		return "paymentInfo";
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/verifypayment" , method = RequestMethod.POST)
	public String paymentInfoPage(@ModelAttribute UserAccount useraccount, Model model, BindingResult bindingResult) {
		List<UserAccount> accounts = account.checkAccount(useraccount.getEmail(), useraccount.getPassword());
		model.addAttribute("useraccount",useraccount);
		if (accounts.size() == 1)
			return "redirect:/cart";
		else
			return "redirect:/checkout";
	}
	
	@RequestMapping(value="/checkout", method=RequestMethod.GET)
	public String checkout(){
		return "checkout";
	}

}
