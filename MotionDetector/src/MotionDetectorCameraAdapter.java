
public class MotionDetectorCameraAdapter implements ImageCapturingDevice {

	Camera camera;
	
	public MotionDetectorCameraAdapter(Camera camera) {
		this.camera = camera;
	}

	@Override
	public byte [] captureImage() {
		return camera.getImage();	
	}
}
