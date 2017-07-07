package space;

import com.ibm.able.AbleBufferConnection;

public class SpaceApp {
	

	public static void main(String[] args){
		try {
			SpaceCorp corpo = new SpaceCorp("Kosmiczne Korpo");
			Customer customer = new Customer();
			corpo.addAbleEventListener(customer);
			
			Thread.sleep(20000);
			
			corpo.quitAll();
			customer.quitAll();
		} catch (Exception e) {
			System.err.println("Error");
			e.printStackTrace();
		}
	}
	
	
	
}



