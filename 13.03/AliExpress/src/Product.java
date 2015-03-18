public class Product {

		String uniqueKey; //ex. P1,P2...
		String name;
		int price, quantity;
		
		public Product(String uniqueKey, String name, int price, int quantity)
		{
			this.uniqueKey = uniqueKey;
			this.name = name;
			this.price = price;
			this.quantity = quantity;
		}

		public String getUniqueKey() {
			return uniqueKey;
		}

		public String getName() {
			return name;
		}

		public int getPrice() {
			return price;
		}

		public int getQuantity() {
			return quantity;
		}
		
		public void printProducts()
		{
			System.out.println("Product name: " + this.name + " Price: " + this.price + " Quantity: " + this.quantity );
		}		
}
