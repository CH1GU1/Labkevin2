package model;
import.java.util.*;
public class Ship{

//attributes
	
	private double totalWeight;
	private Load loads;
	private ArrayList <Load> loads = new ArrayList <Load>();
	
//Constants
	
	public static final String CAPTAIN = "Morgan"
	public static final int MAXWEIGHT = 28000;
	public static final int MINWEIGHT = 12000;
	
//Methods

	public void Ship(double totalWeight, Load pLoads) {
		this.totalWeight = totalWeight;
		loads = pLoads;
		
	}	
	public void loadShip(getBoxes()){
		Object[]array = loads.toArray();
		for(int i = 0; i < Array.length; i++)
			totalWeight += Load.boxes * Load.boxesWeight;  
			
	}	
	public void unloadShip(setTotalWeight()){
		totalWeight = 0;
	}	
	public boolean shipSail() {
		Object[]array = loads.toArray();
		boolean toSail = false;
		if(totalWeight <= MAXWEIGHT && totalWeight >= MINWEIGHT){
			for(int i = 0; i < Array.length, i++){
				for(int j = 1; j < Array.length, j++){
					if(Load[i].loadType =! "DANGEROUS" && load[j].loadType =! "PERISHABLE")
			}
		}
		toSail = true;
	} 
	else
	{		
		toSail = false;
	}
	return toSail;
}	
	public void setTotalWeight(double totalWeight) {
		this.totalWeight = totalWeight;
	}
	public double getTotalWeight(){
		return totalWeight;
	}
	public void addClient(){
		
	}
}	