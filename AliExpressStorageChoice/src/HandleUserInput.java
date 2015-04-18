

import java.util.Scanner;

public class HandleUserInput {
	
	Scanner scanner;
	StoreProducts storage;
	ShowProducts operations;
	ShoppingBasket basket;
	
	public HandleUserInput()
	{
		this.scanner = new Scanner(System.in);
		this.basket = new ShoppingBasket();
	}
	
	public void UserActions()
	{
		askForStorage();		
		printMenu();
		boolean end = false;
		while(!end)
		{			
			String action = scanner.next();
			if(action.equals("1")) 
			{
				operations.showProducts();
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
				basket.totalSumOfProducts(operations);
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
	
	public void askForStorage()
	{
		System.out.println("Enter 1 to store products in warehouse;");
		System.out.println("Enter 2 to store products in database:");
		String store = scanner.next();
		if(store.equals("1"))
		{
			storage = new StoreProductsInWarehouse();
			operations = new WarehouseOperations((StoreProductsInWarehouse) storage);
			storage.storeProducts();
		}
		else
		{
			storage = new StoreProductsInDatabase();
			operations = new DatabaseOperations();
			storage.storeProducts();
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
