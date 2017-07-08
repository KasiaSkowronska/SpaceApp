package space;

import java.util.Vector;

import com.ibm.able.AbleBufferConnection;

public class SpaceApp {
	

	public static void main(String[] args){
		try {
			Vector universum = makeUniversum();
			SpaceCorp corpo = new SpaceCorp("Kosmiczne Korpo");
			corpo.setPlanets(universum);
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
	
	public static Vector makeUniversum(){
		Vector<Planet> universum = new Vector<Planet>();
		Planet planet = new Planet("Pluto");
		//System.out.println(planet.getDistance());
		universum.addElement(planet);
		return universum;
	}
	
	
	
}



