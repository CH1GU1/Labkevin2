package model;

import java.util.ArrayList;

public class Client {

	//attributes

	private String name;
	private double kgSent;
	private String clientType;
	private int register;
	private int expDay;
	private int expMonth;
	private int expYear;

	public ArrayList <Load> Aloads;

	//Constants

	public final static double SILVER = 0.015;
	public final static double GOLD = 0.03;
	public final static double PLATINUM = 0.05;
	public final static double NORMAL = 0;

	//Methods

	public Client(String name, int kgSent, String clientType, int register, int expDay, int expMonth, int expYear){

		this.name = name;
		this.kgSent = kgSent;
		this.clientType = clientType;
		this.register = register;
		this.expDay = expDay;
		this.expMonth = expMonth;
		this.expYear = expYear;

	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setKgSent(double kgSent){
		this.kgSent = kgSent;
	}
	public double getKgSent(){
		return kgSent;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	public String getClientType(){
		return clientType;
	}
	public void setNumber(int register){
		this.register = register;
	}
	public int getNumber(){
		return register;
	}
	public void setDay(int expDay){
		this.expDay = expDay;
	}
	public int getDay(){
		return expDay;
	}
	public void setMonth(int expMonth){
		this.expMonth = expMonth;
	}
	public int getMonth(){
		return expMonth;
	}
	public void setYear(int expYear){
		this.expYear = expYear;
	}
	public int getYear(){
		return expYear;
	}
}