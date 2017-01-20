package src.com.crimsonvision;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

public class MatWindow {
	
	private static Rect biggest = null;
	private static Rect comparison = null ;
	private static final Scalar redText = new Scalar (0,500,500);
	private static ArrayList<MatOfPoint> particles;
	private static List<MatOfPoint> particleRect;

		public Image toBufferedImage(Mat matrix){  //converts Mat to Buffered image.

		int type = BufferedImage.TYPE_BYTE_GRAY;
		if(matrix.channels() > 1){
			type = BufferedImage.TYPE_3BYTE_BGR;
		}
		int bufferSize = matrix.channels()*matrix.cols()*matrix.rows();
		byte [] buffer = new byte[bufferSize];
		matrix.get(0, 0, buffer);//get all the pixels
		BufferedImage image = new BufferedImage(matrix.cols(),matrix.rows(), type);
		final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
		System.arraycopy(buffer, 0, targetPixels, 0, buffer.length);
		return image;
	}

	public void runMainLoop(String args[], Mat webcamMatImage,Mat hsv, Mat thresh,JFrame frame, JLabel imageLabel, JFrame threshFrame, JLabel threshLabel, Rect rect){
 //gets input stream and displays it
		Image tempImage;
		Image tempImg;
		VideoCapture capture = new VideoCapture(0);
		capture.set(Videoio.CAP_PROP_FRAME_WIDTH, 320);
		capture.set(Videoio.CAP_PROP_FRAME_HEIGHT, 240);
		if(capture.isOpened()){
			while(true){
				capture.read(webcamMatImage);
				Imgproc.cvtColor(webcamMatImage, hsv, Imgproc.COLOR_RGB2HSV);
				Core.inRange(hsv, new Scalar(55-27, 0, 106), new Scalar(55+27, 255, 255), thresh);
				if(!webcamMatImage.empty()){
					tempImage = toBufferedImage(webcamMatImage);
					tempImg = toBufferedImage(thresh);
					ImageIcon imgIcon = new ImageIcon(tempImg, "Thresh Video");
					ImageIcon imageIcon = new ImageIcon(tempImage, "Captured Video");
					threshLabel.setIcon(imgIcon);
					imageLabel.setIcon(imageIcon);
					threshFrame.pack();
					frame.pack(); 
					sortCont(thresh,webcamMatImage,rect);
					
				}
				else {
					System.out.println("--Frame not captured-- Break!");
					break;
				}
			}
		}
		else{
			System.out.println("Couldn't open capture");
		}
		
	}
	public static void sortCont(Mat threshImage,Mat mat, Rect rect){
		particles = new ArrayList<MatOfPoint>();
		 particleRect = new ArrayList<MatOfPoint>();
		 Imgproc.findContours(threshImage, particles, new Mat(),
					Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);
		 int biggestWidth = 10;
		 for(int i= particles.size()-1; i>0;i--){
			 MatOfPoint contour = particles.get(i);
			 comparison = Imgproc.boundingRect(contour);
			 int width = comparison.width;
			 if(width> biggestWidth){
				 rect = Imgproc.boundingRect(contour);
				
			 }else{
				 particles.remove(i);
			 }
			 if(biggest !=null)
					Imgproc.rectangle(mat, rect.tl(), rect.br(), redText, 1, Core.LINE_8, 0);
			 
		 }
}
}



