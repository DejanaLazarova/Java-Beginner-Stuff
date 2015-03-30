
public class StopwatchTest {

	public static void main(String[] args) throws Exception {

		final StopWatch task = new StopWatch();
		final Thread taskThread = new Thread(task);
		taskThread.start();
		StopWatchInput stopWatchInput = new StopWatchInput(task,taskThread);
		stopWatchInput.HandleInput();
	}
}
