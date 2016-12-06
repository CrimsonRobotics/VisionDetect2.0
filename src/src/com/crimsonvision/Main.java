package src.com.crimsonvision;


import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
public class Main {
	private static JFrame regFrame;
	private static JLabel regFeed;
	private static JFrame threshFrame;
	private static JLabel threshFeed;
	static{
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}
	public static void main(String args[]){
		Mat reg = new Mat();
		Mat hsv = new Mat();
		Mat thresh = new Mat();
		MatWindow mat = new MatWindow();
		Main app = new Main();
		app.initGui();
		mat.runMainLoop(args, reg, hsv, thresh, regFrame, regFeed, threshFrame, threshFeed);
		
	
		
		
	}
	
	
	public void initGui(){ // Initializes GUI materials. 
		regFrame = new JFrame("Camera Input Example");
		regFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		regFrame.setSize(400, 400);
		regFeed = new JLabel();
		regFrame.add(regFeed);
		regFrame.setVisible(true);
		
		threshFrame = new JFrame("ThreshFrame");
		threshFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		threshFrame.setSize(400, 400);
		threshFeed = new JLabel();
		threshFrame.add(threshFeed);
		threshFrame.setVisible(true);
		
	}


	
	
}