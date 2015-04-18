public class Product {

		String uniquekey;
		String name;
		int price, quantity;
		
		public Product(String uniqueKey, String name, int price, int quantity)
		{
			this.uniquekey = uniqueKey;
			this.name = name;
			this.price = price;
			this.quantity = quantity;
		}

		public String getUniqueKey() {
			return uniquekey;
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
}
