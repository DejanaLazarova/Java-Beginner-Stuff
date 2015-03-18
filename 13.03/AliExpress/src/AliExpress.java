
import java.io.IOException;

public class AliExpress {

	public static void main(String[] args) throws IOException {
		
		ProductWarehouse productWarehouse = new ProductWarehouse();
		productWarehouse.StoreProductsInWarehouse();
		HandleUserInput userInput = new HandleUserInput(productWarehouse);
		userInput.UserActions();
	}
}
