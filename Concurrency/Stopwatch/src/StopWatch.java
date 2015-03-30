public class StopWatch implements Runnable {

	public boolean running = true;
	int i = 1;

	@Override
	public void run() {

		System.out.println("START!");
		
		while (running) {
			System.out.println(String.valueOf(i++));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				synchronized (this) {
					try {
						wait();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}
		}

		if (!running) {
			return;
		}
	}
}
