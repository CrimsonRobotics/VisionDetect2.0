package src.com.crimsonvision;


import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
public class Main {
	private static JFrame regFrame;
	private static JLabel regFeed;
	private static JFrame threshFrame;
	private static JLabel threshFeed;
	private static Mat reg;
	private static Mat hsv;
	private static Mat thresh;
	
	static{
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}
	public static void main(String args[]){
		 reg = new Mat();
		 hsv = new Mat();
		 thresh = new Mat();
		 
		MatWindow mat = new MatWindow();
		Main app = new Main();
		app.initGui();
		Rect biggest = null;
		mat.runMainLoop(args, reg, hsv, thresh, regFrame, regFeed, threshFrame, threshFeed, biggest); 
		
		//Imgproc.rectangle(reg, biggest.tl(), biggest.br(), redText);
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


	
	
