package interfaces;

public interface ShoppingCartOperations {
	
	public void addProductAndQuantity(String productName, Integer quantity);
	
	public void showProductsInCart();
	
	public int totalPaymentSum();

}
