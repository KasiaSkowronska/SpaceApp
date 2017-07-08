package space;

import java.util.Vector;

import com.ibm.able.AbleBufferConnection;

public class SpaceApp {
	

	public static void main(String[] args){
		try {
			Vector universum = makeUniversum();
			SpaceCorp corpo = new SpaceCorp("Kosmiczne Korpo", universum);
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
		Planet planet1 = new Planet("Pluto", "uran");
		Planet planet2 = new Planet("Mars", "wood");
		Planet planet3 = new Planet("Ziemia", "diamonds");
		Planet planet4 = new Planet("N003", "uran");
		//System.out.println(planet.getDistance());
		universum.addElement(planet1);
		universum.addElement(planet2);
		universum.addElement(planet3);
		universum.addElement(planet4);
		return universum;
	}
	
	
	
}



