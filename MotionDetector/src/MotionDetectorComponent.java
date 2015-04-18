import java.util.ArrayList;
import java.util.Arrays;

public class MotionDetectorComponent {

	ImageCapturingDevice device;
	ArrayList<AlarmChannel> alarmChannelSubscribers;
	
	public MotionDetectorComponent(ImageCapturingDevice device) {
		this.device = device;
		this.alarmChannelSubscribers = new ArrayList<AlarmChannel>();
	}

	public void detectChanges() {		
		while(true){
			byte [] imageBytes1 = device.captureImage();
			byte [] imageBytes2 = device.captureImage();
			if(!(Arrays.equals(imageBytes1, imageBytes2))){
				sendAlarm();
			}
		}
	}
	
	public void sendAlarm(){
		for(AlarmChannel s : alarmChannelSubscribers){
			s.writeToConsole();
		}
	}
	
	public void addAlarmSubscriber(AlarmChannel alarm){
		this.alarmChannelSubscribers.add(alarm);
	}

}
