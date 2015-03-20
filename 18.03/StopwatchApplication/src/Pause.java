public class Pause implements Runnable{

	public boolean pause= false;
	Stopwatch stop;
	
	public Pause(Stopwatch stop)
	{
		this.stop = stop;
	}
	
	public void setPause(boolean pause)
	{
		this.pause = pause;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!pause)
		{	
		  synchronized (this) {
			System.out.println("Paused - waiting to proceed");
			try {
				synchronized (this)
				{
					wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		}
		
	}

}
