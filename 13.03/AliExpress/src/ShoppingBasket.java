import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

public class ShoppingBasket {
	
	Hashtable<String, String> basket;
	Scanner scanner;

	public ShoppingBasket()
	{
		this.scanner = new Scanner(System.in);
		this.basket = new Hashtable<String, String>();
	}
	
	public void AddProductAndQuantuty()
	{
		System.out.println("Enter a product name from the list: ");
		String productName = scanner.next();
		System.out.println("Enter desired quantity");
		String quantity = scanner.next();
		basket.put(productName, quantity);
	}
	
	public void printProductsInBasket()
	{
		 System.out.println("Current products in shopping basket: ");
		 Set<String> products = basket.keySet();
	     for(String product : products){
	         System.out.println("Product: "+ product + " Quantity: "+ basket.get(product));
	     }
	}
	
	public void totalSumOfProducts(ProductWarehouse pWarehouse)
	{
		int totalSum=0;
		Set<String> products = basket.keySet();
	     for(String product : products){
	         System.out.println("Product: "+ product + " Quantity: "+ basket.get(product) + " Price: " + pWarehouse.getPriceByProduct(product));
	         int quantity = Integer.parseInt(basket.get(product).toString());
	         totalSum = pWarehouse.getPriceByProduct(product) * quantity;
	     }
	     System.out.println("Total sum for payment: " + totalSum);
	}
}
