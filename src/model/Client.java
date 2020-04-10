package model;

import java.util.ArrayList;

public class Client {

	//attributes

	private String name;
	private double kgSent;
	private String clientType;
	private int register;
	private double valuePaid;
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
	/**
	 *This method is the constructor of Client.
	 *
	 *<b>pre:</b> <br>
	 *
	 *@param name is the name of client
	 *@param kgSent is the historical kilograms transported by client 
	 *@param clientType is the type of client (normal, silver, gold or platinum)
	 *@param register is the unique number per client
	 *@param expDay is the day of expedition of register number
	 *@param expMonth is the month of expedition of register number
	 *@param expYear is the year of expedition of register number
	 *
	 *<b>post:</b> Returns an object of Client type. <br>
	 */
	public Client(String name, int kgSent, String clientType, int register,double valuePaid, int expDay, int expMonth, int expYear){

		this.name = name;
		this.kgSent = kgSent;
		this.clientType = clientType;
		this.register = register;
		this.valuePaid = valuePaid;
		this.expDay = expDay;
		this.expMonth = expMonth;
		this.expYear = expYear;

	}
	/**
	 *This method set the name of client.
	 *
	 *<b>pre:</b> <br>
	 *
	 *@param name is the name of client
	 *
	 *<b>post:</b>Set the client name. <br>
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 *This method get the name of client.
	 *
	 *<b>pre:</b>client was already created <br>
	 *
	 *<b>post:</b>returns the client name. <br>
	 */
	public String getName(){
		return name;
	}
	/**
	 *This method set the historical kilograms transported by client.
	 *
	 *<b>pre:</b> <br>
	 *
	 *@param kgSent is the historical kilograms transported by client.
	 *
	 *<b>post:</b>Set the client kilograms transported. <br>
	 */
	public void setKgSent(double kgSent){
		this.kgSent = kgSent;
	}
	/**
	 *This method get the kgSent by client.
	 *
	 *<b>pre:</b>client was already created <br>
	 *
	 *<b>post:</b>returns the client kgSent. <br>
	 */
	public double getKgSent(){
		return kgSent;
	}
	/**
	 *This method set the client type.
	 *
	 *<b>pre:</b> <br>
	 *
	 *@param clientType is type of client (normal, silver, gold or platinum).
	 *
	 *<b>post:</b>Set the client type. <br>
	 */
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	/**
	 *This method get the client type.
	 *
	 *<b>pre:</b>client was already created <br>
	 *
	 *<b>post:</b>returns the clientType. <br>
	 */
	public String getClientType(){
		return clientType;
	}
	/**
	 *This method set the client number.
	 *
	 *<b>pre:</b> <br>
	 *
	 *@param register is the unique mercantil number of client 
	 *
	 *<b>post:</b>Set the register. <br>
	 */
	public void setNumber(int register){
		this.register = register;
	}
	/**
	 *This method get the number of client.
	 *
	 *<b>pre:</b>client was already created <br>
	 *
	 *<b>post:</b>returns the register number. <br>
	 */
	public int getNumber(){
		return register;
	}
	/**
	 *This method set the value paid by client.
	 *
	 *<b>pre:</b> <br>
	 *
	 *@param valuePaid is the historical price paid by the client
	 *
	 *<b>post:</b>Set the value paid. <br>
	 */
	public void setValuePaid(double valuePaid){
		this.valuePaid = valuePaid;
	}
	/**
	 *This method get the value paid by client.
	 *
	 *<b>pre:</b>client was already created <br>
	 *
	 *<b>post:</b>returns the value paid. <br>
	 */
	public double getValuePaid(){
		return valuePaid;
	}
	/**
	 *This method set the day of expedition of register number.
	 *
	 *<b>pre:</b> <br>
	 *
	 *@param expDay is the expedition day of register number 
	 *
	 *<b>post:</b>Set the day of expedition of register number. <br>
	 */
	public void setDay(int expDay){
		this.expDay = expDay;
	}
	/**
	 *This method get the day of expedition of register number.
	 *
	 *<b>pre:</b> client was already created.<br>
	 *
	 *<b>post:</b>Returns the day of expedition of register number. <br>
	 */
	public int getDay(){
		return expDay;
	}
	/**
	 *This method set the month of expedition of register number.
	 *
	 *<b>pre:</b> <br>
	 *
	 *@param expMonth is the expedition month of register number 
	 *
	 *<b>post:</b>Set the month of expedition of register number. <br>
	 */
	public void setMonth(int expMonth){
		this.expMonth = expMonth;
	}
	/**
	 *This method get the month of expedition of register number.
	 *
	 *<b>pre:</b> client was already created.<br>
	 *
	 *<b>post:</b>Returns the month of expedition of register number. <br>
	 */
	public int getMonth(){
		return expMonth;
	}
	/**
	 *This method set the year of expedition of register number.
	 *
	 *<b>pre:</b> <br>
	 *
	 *@param expYear is the expedition year of register number 
	 *
	 *<b>post:</b>Set the year of expedition of register number. <br>
	 */
	public void setYear(int expYear){
		this.expYear = expYear;
	}
	/**
	 *This method get the year of expedition of register number.
	 *
	 *<b>pre:</b> client was already created.<br>
	 *
	 *<b>post:</b>Returns the year of expedition of register number. <br>
	 */
	public int getYear(){
		return expYear;
	}
}