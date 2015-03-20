public class Resume implements Runnable
{

	public boolean resume;
	Stopwatch stop;
	
	public Resume(Stopwatch stop)
	{
		this.stop = stop;
	}
	
	public void setResume(boolean resume)
	{
		this.resume = resume;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(resume){				
			synchronized(this)
			{
				System.out.println("Seconds: " + String.valueOf(stop.i++));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					resume = false;
					return;
				}
			}
		}
	}
	
	
}
