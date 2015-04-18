package ACMEAdapters;

import ACMEInterfaces.ACMEThermoregulator;

import com.ventoelectrics.waterheater.VentoThermoregulator;

public class ACMEThermoregulatorAdapter implements VentoThermoregulator {
	
	ACMEThermoregulator acmeThermoreg;
	
	public ACMEThermoregulatorAdapter(ACMEThermoregulator acmeThermoreg){
		this.acmeThermoreg = acmeThermoreg;
	}

	@Override
	public void enablePower() {
		acmeThermoreg.enablePower();
	}

	@Override
	public void disablePower() {
		acmeThermoreg.disablePower();
		
	}

	@Override
	public void setTemperature(Integer temperature) {
		acmeThermoreg.setTemperature(temperature);
		
	}

}
