import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class ComplexCalculation implements Callable<Integer> {

	private CountDownLatch latch;

	public ComplexCalculation(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public Integer call() throws Exception {
		latch.countDown();
		return new Random().nextInt(10 + 1);
	}
}
