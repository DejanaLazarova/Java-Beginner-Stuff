package ACMEAdapters;

import com.ventoelectrics.waterheater.VentoHeater;

import ACMEInterfaces.ACMEPoweredDevice;

public class ACMEPoweredDeviceAdapter implements ACMEPoweredDevice {

	VentoHeater ventoHeater;
	
	public ACMEPoweredDeviceAdapter(VentoHeater ventoHeater){
		this.ventoHeater = ventoHeater;
	}
	
	@Override
	public void enable() {
		ventoHeater.enable();
		
	}

	@Override
	public void disable() {
		ventoHeater.disable();
		
	}

}
