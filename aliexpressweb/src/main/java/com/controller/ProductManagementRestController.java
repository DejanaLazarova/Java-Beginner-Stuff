package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.*;
import com.service.ProductServiceImplementation;

@RestController
@RequestMapping("/rest")
public class ProductManagementRestController {
	
	ProductServiceImplementation productService;
	
	@Autowired
	public ProductManagementRestController(ProductServiceImplementation productService) {
		this.productService = productService;
	}

	@RequestMapping(method = RequestMethod.GET)
    public List<Product> listProducts() {
        return productService.findAllProducts();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product insertProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return product;
    }
}
