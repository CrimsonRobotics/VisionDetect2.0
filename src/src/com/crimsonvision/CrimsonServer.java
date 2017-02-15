package src.com.crimsonvision;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.opencv.core.Mat;
import org.opencv.core.Rect;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.ITable;

public class CrimsonServer {
	
public CrimsonServer(Rect rect, Mat mat) throws InterruptedException{
		run(rect,mat);
//server is located at the top of the final if statement in main class
}
public void run(Rect rect, Mat mat){
	/*NetworkTable.setClientMode();
	NetworkTable.setTeam(2526);
	NetworkTable.initialize();*/
	ITable table = NetworkTable.getTable("datatable");
	//table.putNumber("Angle", Utils.calculateAngleOfBoundingBox(mat, rect));
	table.putNumber("Angle", 50.0);
	NetworkTable.initialize();
	//System.out.println(table.getNumber("Number",1000.0));
}
}
