import java.util.Scanner;

public class StopWatchInput {

	Scanner scanner = new Scanner(System.in);
	StopWatch task;
	Thread taskThread;

	public StopWatchInput(StopWatch task, Thread taskThread) {
		this.task = task;
		this.taskThread = taskThread;
	}

	public void HandleInput() {
		while (scanner.hasNext()) {
			String command = scanner.nextLine();

			if (command.equals("pause")) {
				this.pause();
			} else if (command.equals("stop")) {
				this.stop();
			} else if (command.equals("resume")) {
				this.resume();
			}
		}
	}

	public void pause() {
		System.out.println("Paused");
		taskThread.interrupt();
	}

	public void resume() {
		System.out.println("Resuming");
		synchronized (task) {
			task.running = true;
			task.notifyAll();
		}
	}

	public void stop() {
		System.out.println("Stopped");
		task.running = false;
		return;
	}

}
