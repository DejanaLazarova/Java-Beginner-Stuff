
public class ZipCode {
	
	private long zipCode;
	
	public ZipCode(long zipCode){
		this.zipCode = zipCode;
	}
	
	public boolean checkValidity(){
		
		String longNumber = String.valueOf(zipCode);
		int count = longNumber.length();
		if(count == 5 || count == 9)
			return true;
		else
			return false;	
	}
	
	public static void main(String[] args) {
		
		ZipCode zipCode = new ZipCode(1234567);
		if(zipCode.checkValidity()){
			System.out.println("Valid zip code");
		}
		else{
			System.out.println("Invalid zip code");
		}
			
	}
	
	
}
