package src.com.crimsonvision;


import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
public class Main {
	private static JFrame regFrame;
	private static JLabel regFeed;
	static{
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}
	public static void main(String args[]){
		Mat webcamMatImage = new Mat();
		MatWindow mat = new MatWindow();
		Main app = new Main();
		app.initGui();
		mat.runMainLoop(args, webcamMatImage, regFrame, regFeed);
		
	}
	
	
	public void initGui(){ // Initializes GUI materials. 
		regFrame = new JFrame("Camera Input Example");
		regFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		regFrame.setSize(400, 400);
		regFeed = new JLabel();
		regFrame.add(regFeed);
		regFrame.setVisible(true);
		
	}


	
	
}