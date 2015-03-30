import java.util.Scanner;


public class NumberPrinterTest {
	
	private static Scanner scanner;

	public static void main(String[] args) {
		
		final PrintNumbers printNum = new PrintNumbers();
		final Thread taskThread = new Thread(printNum);
		
		System.out.println("Enter a maximum number value and time interval in milliseconds");
		scanner = new Scanner(System.in);
		int maxVal = scanner.nextInt();
		long timeInt = scanner.nextLong();
		printNum.maxVal = maxVal;
		taskThread.start();
		try {
			Thread.sleep(timeInt);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		taskThread.interrupt(); 
	}

}
