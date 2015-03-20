public class Stopwatch implements Runnable{

	boolean running, pause , resume , stop = false;	
	int i=1;
	Pause paused = new Pause(this);
	Resume resumed = new Resume(this);
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while (running) {			
			synchronized (this) {
				System.out.println("Seconds: " + String.valueOf(i++));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return;
				}
			}
		}

	}
	
	public void paused(Stopwatch task)
	{
		paused.setPause(false);
		synchronized (task) {
			notify();
		}
		
	}
	
	public void resume(Stopwatch task) throws InterruptedException
	{
		resumed.setResume(true);
		paused.setPause(true);
		synchronized (task) {
			notify();
		}
	}
}
