package ACMEAdapters;

import com.ventoelectrics.waterheater.VentoThermometer;

public class ACMEThermometerAdapter {
	
	VentoThermometer ventoThermometer;
	
	public ACMEThermometerAdapter(VentoThermometer ventoThermometer){
		this.ventoThermometer = ventoThermometer;
	}
	
	public Integer getTemperature(){
		return ventoThermometer.getTemperature();
	}

}
