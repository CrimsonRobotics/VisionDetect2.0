package crimsonclient;

import java.util.logging.Level;
import java.util.logging.Logger;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class crimsonClient {

	static NetworkTable table;
	public static void main(String args[]){
	table.setServerMode();
	table = NetworkTable.getTable("datatable");
	while(true){
	try{
        Thread.sleep(250);
    } catch (InterruptedException ex)
        {
Logger.getLogger(crimsonClient.class.getName()).log(Level.SEVERE, null, ex);
        }
	System.out.println(table.getNumber("Number", -1000.0));
	}
	
		/*NetworkTable.setClientMode();
		NetworkTable.setIPAddress("10.25.26.2");
		NetworkTable table = NetworkTable.getTable("datatable");*/
	
	}
}
