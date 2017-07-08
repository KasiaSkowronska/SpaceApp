package space;

import java.util.Random;

public class Planet {
	
	public String name;
	public Integer distance;
	public String stockType;
	
	
	
	public Planet(String name) {
		this.name = name;
		this.distance = new Random().nextInt(1000);
		this.stockType = "diamonds";
	}
	public String getName() {
		return name;
	}
	public Integer getDistance() {
		return distance;
	}
	
	

}
