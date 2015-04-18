
public class MotionDetectorAlarmAdapter implements AlarmChannel {

	AlarmChannelSubscriber subscriber;
	
	public MotionDetectorAlarmAdapter(AlarmChannelSubscriber subscriber) {
		this.subscriber = subscriber;
	}
	
	@Override
	public void writeToConsole() {
		subscriber.writeMessage();		
	}

}
