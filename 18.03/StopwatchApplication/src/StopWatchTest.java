public class StopWatchTest {
	
	public static void main(String[] args) throws InterruptedException{
		
		
		final Stopwatch task = new Stopwatch();
		final Thread taskThread = new Thread(task);
		//task.start = true;
		taskThread.start();
		task.running = true;
		Thread.sleep(5000);
		
		
		/*
		System.out.println("Please stop");
		
		synchronized (task) {
			task.stop = true;		
			task.notify();
		} */
		
		System.out.println("Please pause");
		task.running = false;
		Thread.sleep(5000);
		task.paused(task);
		
		System.out.println("Please resume");
		Thread.sleep(5000);
		task.resume(task);
	
		
		
		
	}

}
