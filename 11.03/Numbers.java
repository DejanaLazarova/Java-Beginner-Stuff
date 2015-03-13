import java.util.Scanner;

public class Numbers {

	private static Scanner scanner;

	static int getNumber(String number) {
		int num = 0;
		switch (number) {
		case "one":
			num = 1;
			break;
		case "two":
			num = 2;
			break;
		case "three":
			num = 3;
			break;
		case "four":
			num = 4;
			break;
		case "five":
			num = 5;
			break;
		case "six":
			num = 6;
			break;
		case "seven":
			num = 7;
			break;
		case "eight":
			num = 8;
			break;
		case "nine":
			num = 9;
			break;
		}
		return num;
	}

	public static void main(String[] args) {

		// from command line
		for (int i = 0; i < args.length; i++) {
				System.out.print(getNumber(args[i]));
		}
		
		//user input
		System.out.println("Enter three words");
		String [] numbers = new String[3];
		scanner = new Scanner (System.in);
		
		for(int i=0; i<numbers.length;i++)
		{
			numbers[i] = scanner.next();
		}
		
		for(int i=0; i<numbers.length;i++)
		{
			System.out.print(getNumber(numbers[i]));
		}
		

	}

}
