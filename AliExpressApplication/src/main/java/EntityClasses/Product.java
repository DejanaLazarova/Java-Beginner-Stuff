package EntityClasses;

import javax.persistence.*;

@Entity
public class Product {
	
	@Id
	private int id;
	@Column(name = "name")
	private String productName;
	@Column(name = "price")
	private int productPrice;
	@Column(name = "quantity")
	private int productQuantity;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	
	public Product(){}
	
	public Product(int id, String productName, int productPrice, int productQuantity) {
		this.id = id;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
	}
	
	

}
