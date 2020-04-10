package model;
import java.util.*;
public class Ship{

	//attributes

	private String name;

	//relation

	public ArrayList <Load> Aloads;
	public Client [] clients = new Client[5];

	//Constants

	public static final String CAPTAIN = "Morgan";
	public static final int MAXWEIGHT = 28000;
	public static final int MINWEIGHT = 12000;

	//Methods

	/**
	 *This is method calculate the value to paid by client depend of load type and without discount.
	 *
	 *<b>pre:</b>A load for a client was created as minimum. <br>
	 *
	 *@param result is the total kilograms of the load   
	 *@param loadType is the type of load
	 *
	 *<b>post:</b> returns result is the operation of multiply kilograms of load and the type of load. <br>
	 */
	public double calculateParcialValue(double result, String loadType){

		if(loadType.equalsIgnoreCase("DANGEROUS")) 
			result*=390000;
		else if(loadType.equalsIgnoreCase("PERISHABLE"))
			result*=250000;
		else if(loadType.equalsIgnoreCase("NOTPERISHABLE"))
			result*=80000;

		return result;
	}
	/**
	 *This is method calculate the value to paid by client depend of the client type and apply the discount.
	 *
	 *<b>pre:</b>A load for a client was created as minimum. <br>
	 *
	 *@param mult is the result of parcial value to pay   
	 *@param loadType is the type of load
	 *
	 *<b>post:</b> Returns mult is the operation of apply the discount. <br>
	 */
	public double calculateTotalValuePaid(double mult, String clientType) {
		if(clientType.equalsIgnoreCase("SILVER") ) {
			double value=mult*Client.SILVER;
			mult-=value;
		}
		else if(clientType.equalsIgnoreCase("GOLD")) {
			double value=mult*Client.GOLD;
			mult-=value;
		}
		else if(clientType.equalsIgnoreCase("PLATINUM")) {
			double value=mult*Client.PLATINUM;
			mult-=value;
		}
		else {
			return mult;
		}
		return mult;
	}
	/**
	 *This is method check if a new load can be added or not depend of the total weight of the ship.
	 *
	 *<b>pre:</b> <br>
	 *
	 *<b>post:</b> Returns add is a boolean when decide if a new load can be added. <br>
	 */
	public boolean addLoad() {
		boolean add = true;
		if(calculateTotalWeight()>MAXWEIGHT) {
			add = false;
		}
		return add;
	}
	/**
	 *This method is the constructor of Ship.
	 *
	 *<b>pre:</b> <br>
	 *
	 *@param name is the name of ship called "Morgan" 
	 *
	 *<b>post:</b> Returns an object of Ship type. <br>
	 *<b>post:</b> Create the array of loads. <br>
	 */
	public Ship(String name) {
		this.name = name;
		Aloads = new ArrayList <Load>();	
	}
	/**
	 *This is method get the name of ship.
	 *
	 *<b>pre:</b> The ship name is already created<br>
	 *
	 *<b>post:</b> Returns name as String of ship name. <br>
	 */
	public String getName() {
		return name;
	}
	/**
	 *This is method calculate the total weight of the ship.
	 *
	 *<b>pre:</b>A load was created as minimum (the array is not null). <br>
	 *
	 *<b>post:</b> Returns pTotalWeight int is the total weight of the ship. <br>
	 */
	public int calculateTotalWeight(){
		int pTotalWeight = 0;
		if(Aloads!=null) {
			for(int i = 0; i < Aloads.size(); i++) {
				int x = 0;
				x = (Aloads.get(i).getBoxes()*Aloads.get(i).getBoxesWeight());
				pTotalWeight += x;
			}
		}
		return pTotalWeight;
	}	
	/**
	 *This is method calculate the type of client.
	 *
	 *<b>pre:</b>A load of client was created as minimum. <br>
	 *<b>pre:</b>The client has successfully submitted a load at least. <br>
	 *
	 *@param kgSent is the attribute of client about the historical kilograms sent  
	 *@param totalValue is value with discount to pay
	 *@param select is the position of the array of clients
	 *
	 *<b>post:</b> Returns updated as boolean that means if the client was upgrated to a new category or not. <br>
	 *<b>post:</b> Sets the new category of client or not. <br>
	 */
	public boolean calculateClientType(double kgSent, double totalValue, int select) {
		boolean updated = false;
		if(kgSent>=35000 && clients[select].getClientType() == "NORMAL") {
			clients[select].setClientType("SILVER");
			updated = true;
		}
		else if(kgSent>=55000||totalValue>=2000000 && clients[select].getClientType() == "SILVER") {
			clients[select].setClientType("GOLD");
			updated = true;
		}

		else if(totalValue>=5000000 && clients[select].getClientType() == "GOLD") {
			clients[select].setClientType("PLATINUM");
			updated = true;
		}
		return updated;
	}
	/**
	 *This is method shows if the client was upgrated or not.
	 *
	 *<b>pre:</b>A load of client was created as minimum. <br>
	 *<b>pre:</b>The client has successfully submitted a load at least. <br>
	 *
	 *@param updated is a boolean that means if the client was upgrated to a new category or not  
	 *@param select is the position of the array of clients
	 *
	 *<b>post:</b> Returns message if the client was upgrated to a new category or not. <br>
	 */
	public String notifyNewClientType(boolean updated, int select) {
		String message = "";
		if(updated == true) {
			message = "The client: "+clients[select].getName()+" is updated to the category: "+clients[select].getClientType()+" \n";
		} 
		else if
		(updated == false) {
			message = "The client: "+clients[select].getName()+" is not allowed to updated new category, keeps on: "+clients[select].getClientType()+" \n";
		}
		return message;
	}
	/**
	 *This is method unload the ship.
	 *
	 *<b>pre:</b> <br>
	 *
	 *<b>post:</b> Returns message if the notifying the ship was unload. <br>
	 */
	public String unloadShip(){
		String message = "";
		Aloads.clear();
		message = "Ship empty by method";
		return message;
	}	
	/**
	 *This is method check if the ship can sail or not depend of the conditions.
	 *
	 *<b>pre:</b>A load of a client was created as minimum. <br>
	 *
	 *<b>post:</b> Returns toSail as boolean to know if the ship can sail or not. <br>
	 */
	public boolean shipSail() {
		boolean toSail; 
		if((calculateTotalWeight()>=MINWEIGHT || Aloads.size() >= 2) && sanityCondition() == true && calculateTotalWeight()<=MAXWEIGHT){
			toSail = true;
		}else { 
			toSail = false;
		}
		return toSail;
	}
	/**
	 *This is method check the sanity conditions of the loads.
	 *
	 *<b>pre:</b>A load of client was created as minimum. <br>
	 *
	 *<b>post:</b> Returns correct as boolean if the loads accomplish with the sanity conditions. <br>
	 */
	public boolean sanityCondition() {
		boolean correct = true;
		for (int i = 0; i < Aloads.size(); i++) {
			for (int j = 1; j < Aloads.size(); j++) { 
				if((Aloads.get(i).getLoadType().equalsIgnoreCase("DANGEROUS") && Aloads.get(j).getLoadType().equalsIgnoreCase("PERISHABLE"))||(Aloads.get(i).getLoadType().equalsIgnoreCase("PERISHABLE")&&Aloads.get(j).getLoadType().equalsIgnoreCase("DANGEROUS")))
					correct = false;
			}     
		}return correct;
	}
	/**
	 *This is method search the client by his name.
	 *
	 *<b>pre:</b>A client was created as minimum. <br>
	 *<b>pre:</b>The client has successfully submitted a load at least. <br>
	 *
	 *@param name the name of client to search  
	 *
	 *<b>post:</b> Returns objSearch as an object of Client type. <br>
	 */
	public Client searchClient(String name) {
		Client objSearch=null;
		boolean findClient = false;
		for(int i = 0; i < clients.length && !findClient; i++) {
			if(clients[i]!=null) {
				if(clients[i].getName().equals(name)) {
					objSearch = clients[i];
					findClient=true;
				}

			}
		}
		return objSearch;	
	}
	/**
	 *This is method calculate the historical kilograms sent by the client.
	 *
	 *<b>pre:</b>A client was created as minimum. <br>
	 *<b>pre:</b>The client has successfully submitted a load at least. <br>
	 *
	 *@param name the name of client  
	 *
	 *<b>post:</b> Returns result of calculate the historical kilgroams per client. <br>
	 */
	public int totalKgSentClient(String name) {
		int result = 0;
		for (int i = 0; i < Aloads.size(); i++) {
			String x = Aloads.get(i).getOwner();
			if(name.equals(x)){
				result+=(Aloads.get(i).getBoxesWeight()*Aloads.get(i).getBoxes());
			}
		}
		return result;
	}
	/**
	 *This is method adds a new load weight to the historical kilograms transported by client.
	 *
	 *<b>pre:</b>A client was created as minimum. <br>
	 *<b>pre:</b>The client has successfully submitted a load at least. <br>
	 *
	 *@param name the name of client to search  
	 *@param x is the weight of the load of a client
	 */
	public void totalAccumulate(int x, String name) { 
		for (int i = 0; i < clients.length; i++) {
			if(clients[i].getName().equalsIgnoreCase(name)) {
				double a = clients[i].getKgSent();
				a+=x;
				clients[i].setKgSent(a);
			}
		}
	}
}