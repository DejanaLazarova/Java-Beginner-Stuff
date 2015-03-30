
public class VentoHeater implements VentoPoweredDevice {
	
	private boolean powerEnabled = false;
	
	public void enablePower() {
		powerEnabled = true;
	}

	public void disablePower() {
		powerEnabled = false;
	}
	
	public void enable() {
		if (!powerEnabled) {
			throw new NoPowerException();
		}
		System.out.println("VentoHeater.enable()");
	}
	
	public void disable() {
		System.out.println("VentoHeater.disable()");
	}
}
