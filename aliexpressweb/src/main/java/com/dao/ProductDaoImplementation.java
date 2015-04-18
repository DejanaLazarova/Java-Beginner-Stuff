package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.model.Product;
import com.templateclasses.AliExpressTemplateClass;
import com.templateclasses.ExecuteOperations;


@Repository("productDao")

public class ProductDaoImplementation implements ProductDao{

	@Override
	public void saveProduct(final Product product) {
		new AliExpressTemplateClass().executeTask(new ExecuteOperations() {
			public void executeOperation(Session session) {
				session.save(product);
			}
		});		
	}

	@Override
	public void deleteProductByName(final String name) {
		new AliExpressTemplateClass().executeTask(new ExecuteOperations() {
			public void executeOperation(Session session) {
				Query query = session.createQuery("DELETE FROM product WHERE productName = :name");
				query.setParameter("name", name);
				query.executeUpdate();
			}
		});
	}

	@Override
	public void updateProduct(final String oldName, final String newName, final int newPrice, final int newQuantity) {
		new AliExpressTemplateClass().executeTask(new ExecuteOperations() {
			public void executeOperation(Session session) {
				Query query = session.createQuery("UPDATE Product SET name = :newName, price = :newPrice, quantity = :newQuantity WHERE productName = :name");
				query.setParameter("name", newName);
				query.setParameter("newPrice", newPrice);
				query.setParameter("newQuantity", newQuantity);
				query.setParameter("name", oldName);
				query.executeUpdate();
			}
		});	
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Product> listProducts() {
		return new AliExpressTemplateClass()
		.returnTask(new ExecuteOperations() {
			@Override
			public List executeOperation(Session session, List result) {
				Criteria cr = session.createCriteria(Product.class);
			    result = cr.list();
				return (List<Product>)result;
			}
		});
	}
}
