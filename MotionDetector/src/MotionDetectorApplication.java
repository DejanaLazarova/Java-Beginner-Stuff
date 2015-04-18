
public class MotionDetectorApplication {

	public static void main(String[] args) {
		
		Camera camera = new Camera();
		AlarmChannelSubscriber subscriber1 = new AlarmChannelSubscriber();
		AlarmChannelSubscriber subscriber2 = new AlarmChannelSubscriber();
		
		ImageCapturingDevice cameraAdapter = new MotionDetectorCameraAdapter(camera);
		AlarmChannel alarmChannel = new MotionDetectorAlarmAdapter(subscriber1);
		AlarmChannel alarm2 = new MotionDetectorAlarmAdapter(subscriber2);
		
		MotionDetectorComponent cameraComponent = new MotionDetectorComponent(cameraAdapter);
		cameraComponent.addAlarmSubscriber(alarmChannel);
		cameraComponent.addAlarmSubscriber(alarm2);
		cameraComponent.detectChanges();	
		cameraComponent.sendAlarm();
	}
}
