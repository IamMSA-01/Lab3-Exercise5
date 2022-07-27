import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataReader {

	public static void main(String[] args) {

		// 1. Declare output file 
		String sourceFile = "data.txt";
		System.out.println("Reading data from " + sourceFile + "\n");

		try {

			// 2. Create stream to read data
			DataInputStream dis = new DataInputStream(new FileInputStream(sourceFile));

			// Variables for processing byte-based data
			double utlization = 0;
			double totalUtilization = 0;
			int noOfRecords = 0;
			int id = 0;
			String station = "";
			String district = "";
			
			// 3. Process data until end-of-file
			while(dis.available() > 0) {
				
				// Read data
				id= dis.readInt();
				station = dis.readUTF();
				district = dis.readUTF();
				utlization = dis.readDouble();
				System.out.println( id + "\t" + station+ "\t" +  district + "\t" + utlization);
				
				
				// Calculate total utilization
				totalUtilization += utlization;
				noOfRecords ++;
			}
			
			// 4. Close stream
			dis.close();
			
			// Calculate average utlization
			double averageUtlization = totalUtilization / noOfRecords;
			String formattedAverage = String.format("%.1f", averageUtlization);
			System.out.print("\nAverage rain for " + noOfRecords 
					+ " station: " + formattedAverage + "%");
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}

		// Indicate end of program - Could be successful
		System.out.println("\nEnd of program.");
		

	}

}
