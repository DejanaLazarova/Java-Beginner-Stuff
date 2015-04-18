package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.model.Product;
import com.service.ProductServiceImplementation;

@Controller
@RequestMapping("/products")
public class ProductManagementController {

	ProductServiceImplementation productService;
	List<Product> products = new ArrayList<Product>();

	@Autowired
	public ProductManagementController(ProductServiceImplementation productService) {
		this.productService = productService;
	}

	@ModelAttribute
	public Product product() {
		return new Product();
	}

	@ModelAttribute("products")
	public List<Product> getProducts() {
		return productService.findAllProducts();
	}

	@RequestMapping(method=RequestMethod.GET)
	public String listProducts(){
		return "allproducts";
	}
	
	@RequestMapping(value="/add" , method = RequestMethod.GET)
	public String listBooks() {
		return "addproduct";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitProducts(@ModelAttribute Product product) {
		productService.saveProduct(product);
		return "redirect:/products";
	}

	


}
