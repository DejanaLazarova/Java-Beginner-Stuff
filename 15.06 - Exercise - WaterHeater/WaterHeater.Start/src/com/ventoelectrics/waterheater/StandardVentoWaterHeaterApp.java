package com.ventoelectrics.waterheater;

import ACMEAdapters.*;
import ACMEInterfaces.ACMEPoweredDevice;
import ACMEThermoregulators.ACMEStandardThermoregulator;

public class StandardVentoWaterHeaterApp {

	public static void main(String[] args) throws Exception {

		final VentoThermometer ventoThermometer = new VentoThermometer();
		final VentoHeater ventoHeater = new VentoHeater();
		final VentoPowerSwitch ventoPowerSwitch = new VentoPowerSwitch();
		
		final ACMEThermometerAdapter adapter = new ACMEThermometerAdapter(ventoThermometer);
		final ACMEPoweredDevice device = new ACMEPoweredDeviceAdapter(ventoHeater);

		final VentoThermoregulator ventoThermoregulator = new ACMEThermoregulatorAdapter(
				new ACMEStandardThermoregulator(adapter, device));
		// ACME standard thermoregulator instance. 

		ventoPowerSwitch.controlPowerFor(ventoThermoregulator);
		ventoPowerSwitch.controlPowerFor(ventoHeater);
		ventoPowerSwitch.controlPowerFor(ventoThermometer);

		VentoWaterHeaterApp.run(ventoThermoregulator, ventoPowerSwitch);
	}
}
