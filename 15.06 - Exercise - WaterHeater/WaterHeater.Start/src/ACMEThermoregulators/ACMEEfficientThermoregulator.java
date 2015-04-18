package ACMEThermoregulators;

import ACMEAdapters.ACMEThermometerAdapter;
import ACMEInterfaces.ACMEPoweredDevice;
import ACMEInterfaces.ACMEThermoregulator;

public class ACMEEfficientThermoregulator implements ACMEThermoregulator {

	ACMEThermometerAdapter adapter;
	ACMEPoweredDevice device;
	Integer temperature = 0;
	boolean running = true;
	int seconds = 1;
	

	public ACMEEfficientThermoregulator(ACMEThermometerAdapter adapter,
			ACMEPoweredDevice device) {
		super();
		this.adapter = adapter;
		this.device = device;
	}

	Thread ACMEThermoregulator = new Thread() {
		@Override
		public void run() {
			while (running) {
				try {
					Thread.sleep(seconds);
					Integer capturedTemperature = adapter.getTemperature();
					if (capturedTemperature < temperature) {
						device.enable();
					} else if (capturedTemperature > temperature) {
						device.disable();
					}
				} catch (Exception e) {}
			}
		}
	};

	@Override
	public void enablePower() {
		ACMEThermoregulator.start();
	}

	@Override
	public void disablePower() {
		running = false;
	}

	@Override
	public void setTemperature(Integer newtemp) {
		temperature = newtemp;
	}

}
