package com.ventoelectrics.waterheater;
import ACMEAdapters.ACMEPoweredDeviceAdapter;
import ACMEAdapters.ACMEThermometerAdapter;
import ACMEAdapters.ACMEThermoregulatorAdapter;
import ACMEInterfaces.ACMEPoweredDevice;
import ACMEThermoregulators.ACMEEfficientThermoregulator;

public class EfficientVentoWaterHeaterApp {

	public static void main(String[] args) throws Exception {

		final VentoThermometer ventoThermometer = new VentoThermometer();
		final VentoHeater ventoHeater = new VentoHeater();
		final VentoPowerSwitch ventoPowerSwitch = new VentoPowerSwitch();

		final ACMEThermometerAdapter adapter = new ACMEThermometerAdapter(ventoThermometer);
		final ACMEPoweredDevice device = new ACMEPoweredDeviceAdapter(ventoHeater);

		final VentoThermoregulator ventoThermoregulator = new ACMEThermoregulatorAdapter(
				new ACMEEfficientThermoregulator(adapter, device));
		
		// ACME efficient thermoregulator instance. 

		ventoPowerSwitch.controlPowerFor(ventoThermoregulator);
		ventoPowerSwitch.controlPowerFor(ventoHeater);
		ventoPowerSwitch.controlPowerFor(ventoThermometer);

		VentoWaterHeaterApp.run(ventoThermoregulator, ventoPowerSwitch);
	}
}
