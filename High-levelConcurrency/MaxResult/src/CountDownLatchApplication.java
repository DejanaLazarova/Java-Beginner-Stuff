import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CountDownLatchApplication {

	private static final int NUMBER_OF_OPERATIONS = 10;

	public static void main(String[] args) throws Exception {

		final CountDownLatch latch = new CountDownLatch(NUMBER_OF_OPERATIONS);
		final ExecutorService executorService = Executors.newCachedThreadPool();
		ArrayList<Integer> values = new ArrayList<>();

		for (int i = 1; i <= NUMBER_OF_OPERATIONS; i++) {
			final Future<Integer> complexCalculationFuture = executorService.submit(new ComplexCalculation(latch));
			final Integer complexCalculationResult = complexCalculationFuture.get();
			values.add(complexCalculationResult);
			System.out.println("Complex calculation " + i + " result is " + complexCalculationResult);
		}

		System.out.println("Waithing for all complex calculations to finish...");
		latch.await();
		System.out.println("All complex calculations finished.");
		Integer maxResult = maxResult(values);
		System.out.println("The largest result is " + maxResult);
		executorService.shutdown();
	}

	public static Integer maxResult(ArrayList<Integer> values) {
		Integer max = 0;
		for (Integer value : values) {
			if (value > max) {
				max = value;
			}
		}
		return max;
	}
}
