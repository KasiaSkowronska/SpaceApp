package space;

import java.util.Random;

public class Planet {
	
	public String name;
	public Integer distance;
	public String stockType;
	
	
	
	public Planet(String name, String stockType) {
		this.name = name;
		this.distance = new Random().nextInt(1000);
		this.stockType = stockType;
	}
	public String getName() {
		return name;
	}
	public Integer getDistance() {
		return distance;
	}
	
	

}
