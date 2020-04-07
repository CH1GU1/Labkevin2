package model;
import.java.util.*;
public class Client {

//attributes
	
	private String name;
	private int kgSent;
	private int parcialValue;
	private int totalValue;
	private String clientType;
	private int register;
	private int expDay;
	private int expMonth;
	private int expYear;
	
//Constants

private final static int SILVER = 0.015;
private final static int GOLD = 0.03;
private final static int PLATINUM = 0.05;
private final static int NORMAL = 0;

//Methods
	
public Client(String name, int kgSent, int parcialValue, int totalValue, String clientType, String register, int expDay, int expMonth, int expYear){

this.name = name;
this.kgTransported = kgTransported;
this.valuePaid = valuePaid;
this.clientType = clientType;
this.register = register;
this.expDay = expDay;
this.expMonth = expMonth;
this.expYear = expYear;

}
public void setName(String name){
	this.name = name;
}
public getName(){
	return name;
}
public void setParcialValue(int parcialValue){
	this.valuePaid = valuePaid;
}
public getParcialValue(){
	return valuePaid;
}
public void setKgSent(int kgSent){
	this.kgSent = kgSent;
}
public getKgSent(){
	return kgSent;
}
public void calculateClientType(int totalValue, int kgSent){
	
}
public getClientType(){
	return clientType;
}
public void calculateTotalValue(int parcialValue, String clientType){
	
}
public getTotalValue(){
	return totalValue;
}
public void setNumber(int number){
	this.number = number;
}
public getNumber(){
	return number;
}
public void setDay(int expDay){
	this.expDay = expDay;
}
public getDay(){
	return expDay;
}
public void setMonth(int expMonth){
	this.expMonth = expMonth;
}
public getMonth(){
	return expMonth;
}
public void setYear(int expYear){
	this.expYear;
}
public getYear(){
	return expYear;
}
}