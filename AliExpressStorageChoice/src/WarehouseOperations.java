
public class WarehouseOperations implements ShowProducts
{

	StoreProductsInWarehouse store;
	
	public WarehouseOperations(StoreProductsInWarehouse store)
	{
		this.store = store;
	}
	
	@Override
	public void showProducts() {
		for(Product p: store.getProducts())
		{
			System.out.println("Product name: " + p.getName() + 
					          " Price: " + p.getPrice() + 
					          " Quantity: " + p.getQuantity());
		}
		
	}

	@Override
	public int getPriceByProductName(String product) {
		int price = 0;
		for(Product p: store.getProducts())
		{
			if(p.getName().equals(product))
			{
				price = p.getPrice();
			}
		}
		return price;
	}

}
