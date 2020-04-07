package model;
import.java.util.*;
public class Load{
	
	//attributes
	
	private int boxes;
	private double boxesWeight;
	private String loadType;
	private Client owner;
	
		
	//Constants
	
	private final static int DANGEROUS = 390000;
	private final static int PERISHABLE = 250000;
	private final static int PERISHABLE = 80000;
	
	//Methods
	
	public void Load(int boxes, double boxesWeight, String loadType, Client isOwner ){
		this.boxes = boxes;
		this.boxesWeight = boxesWeight;
		this.loadType = loadType;
		owner = isOwner;
		
	}
	public void setBoxes(int boxes){
		this.boxes = boxes;
	}
	public int getBoxes(){
		return boxes;
	}
	public void setBoxesWeight(double boxesWeight){
		this.boxesWeight = boxesWeight;
	}
	public double getBoxesWeight(){
		return boxesWeight;
	}
	public double getTotalWeight(){
		return totalWeight;
	}
	public void setLoadType(String loadType){
		this.loadType = loadType;
	}
	public String getLoadType(){
		return loadType;
	}
}