package src.com.crimsonvision;



import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

public class Utils {
	private static final Scalar redText = new Scalar (0,500,500);
	public static void putRect(Mat mat, Rect rect){
		Imgproc.rectangle(mat, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), redText);
	}
	
}
