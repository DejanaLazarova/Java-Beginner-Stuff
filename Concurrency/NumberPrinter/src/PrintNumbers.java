public class PrintNumbers implements Runnable {

	public int maxVal;

	@Override
	public void run() {

		for (int i = 1; i <= maxVal; i++) {
			System.out.println(String.valueOf(i));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Failed to complete");
				return;
			}
		}		
		System.out.println("Finished.");
	}
}
