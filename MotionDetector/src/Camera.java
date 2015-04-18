import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Camera {
	
	BufferedReader reader;
	
	public Camera(){
		this.reader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public byte [] getImage(){
		
		byte [] imageBytes = null;
		try {
			String img = reader.readLine();
			imageBytes = img.getBytes("UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imageBytes;
	}
}
