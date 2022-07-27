import java.io.DataOutputStream;
import java.io.FileOutputStream;
public class DataGenarator  {

	public static void main (String args[]) {
		
		String outFile = "data.txt";
		
		// Data declaration
				int id[] = {2421003,2322006,2321006,2222002};
				String station[] = {"Simpang Ampat", "Melaka Pindah ", "Ladang Lendu","Durian Tunggal"};
				String district[] = {"Alor Gajah", "Alor Gajah", "Alor Gajah","Alor Gajah"};
				
				double utilizations[] = {44.0,5.0,1.0,6.0,9.0,13.5,0.0,0.0,58.5,115.0,0.0,7.5,3.0,12.0,10.0};
		
				try {
					
					// 2. Create stream to read data
					DataOutputStream dos = new DataOutputStream(new FileOutputStream(outFile));
					
					// Process data
					for (int index = 0; index < id.length; index++) {
						
						// 3. Write data into data stream
						dos.writeInt(id[index]);
						dos.writeUTF(station[index]);
						dos.writeUTF(district[index]);
						dos.writeDouble(utilizations[index]);
						
						// 4. Flush for each writing
						dos.flush();
					}
					
					// 5. Close stream
					dos.close();
					
				} catch (Exception ex) {
					
					ex.printStackTrace();
				}
				
				// Indicate end of program - Could be successful
				System.out.println("End of program. Check out " + outFile); 
		
	}
	
	
}
