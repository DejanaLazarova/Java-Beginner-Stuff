
import java.util.Random;

public class VentoThermometer implements VentoPoweredDevice {
	
	private boolean powerEnabled = false;
	private Random random = new Random(System.currentTimeMillis());

	public Integer getTemperature() {
		if (!powerEnabled) {
			throw new NoPowerException();
		}
		return random.nextInt(60);
	}

	public void enablePower() {
		powerEnabled = true;
	}

	public void disablePower() {
		powerEnabled = false;
	}
}
