

import java.util.Scanner;

public class HandleUserInput {
	
	Scanner scanner;
	ProductWarehouse pWarehouse;
	ShoppingBasket basket;
	
	public HandleUserInput(ProductWarehouse pWarehouse)
	{
		this.scanner = new Scanner(System.in);
		this.pWarehouse = pWarehouse;
		this.basket = new ShoppingBasket();
	}
	
	public void UserActions()
	{
		printMenu();
		boolean end = false;
		while(!end)
		{			
			String action = scanner.next();
			if(action.equals("1")) 
			{
				pWarehouse.printProductsInWarehouse();
				end = false;
			}
			else if (action.equals("2"))
			{
				basket.AddProductAndQuantuty();
				basket.printProductsInBasket();
				end = false;
			}
			else if (action.equals("3"))
			{
				basket.totalSumOfProducts(pWarehouse);
				end = false;
			}
			else if(action.equals("end"))
			{
				end = true;
				System.out.println("BYE.");
				break;
			}
		}
	}
	
	public void printMenu()
	{
		System.out.println("Please choose an action from the list below:");
		System.out.println("Enter 1 to list all products in the warehouse");
		System.out.println("Enter 2 to add a product and a quantity to your basket");
		System.out.println("Enter 3 to proceed to checkout");
		System.out.println("Enter end to exit");
	}

}
