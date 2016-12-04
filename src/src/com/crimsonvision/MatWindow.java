package src.com.crimsonvision;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

public class MatWindow {
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
	public void runMainLoop(String args[], Mat webcamMatImage, JFrame frame, JLabel imageLabel){ //gets input stream and displays it
		Image tempImage; 
		VideoCapture capture = new VideoCapture(0);
		capture.set(Videoio.CAP_PROP_FRAME_WIDTH, 320);
		capture.set(Videoio.CAP_PROP_FRAME_HEIGHT, 240);
		if(capture.isOpened()){
			while(true){
				capture.read(webcamMatImage);
				if(!webcamMatImage.empty()){
					tempImage = toBufferedImage(webcamMatImage);
					ImageIcon imageIcon = new ImageIcon(tempImage, "Captured Video");
					imageLabel.setIcon(imageIcon);
					frame.pack(); 
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
}

