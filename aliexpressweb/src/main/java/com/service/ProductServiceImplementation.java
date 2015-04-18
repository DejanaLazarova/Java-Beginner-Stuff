package com.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.ProductDaoImplementation;
import com.model.Product;

@Service("productService")
@Transactional
public class ProductServiceImplementation implements ProductService{
	
	
	private ProductDaoImplementation productDao;
	
	@Autowired
	public ProductServiceImplementation(ProductDaoImplementation productDao){
		this.productDao = productDao;
	}

	@Override
	public void saveProduct(Product product) {
		productDao.saveProduct(product);	
	}

	@Override
	public List<Product> findAllProducts() {
		return productDao.listProducts();
	}

	@Override
	public void removeProductByName(String name) {
		productDao.deleteProductByName(name);		
	}

	@Override
	public void editProduct(String oldnName, String newName, int newPrice, int newQuantity) {
		productDao.updateProduct(oldnName, newName, newPrice, newQuantity);
	}
}
