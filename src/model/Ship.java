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


	public double calculateParcialValue(double result, String loadType){

		if(loadType.equalsIgnoreCase("DANGEROUS")) 
			result*=390000;
		else if(loadType.equalsIgnoreCase("PERISHABLE"))
			result*=250000;
		else if(loadType.equalsIgnoreCase("NOTPERISHABLE"))
			result*=80000;

		return result;
	}
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
	public boolean addLoad() {
		boolean add = true;
		if(calculateTotalWeight()>MAXWEIGHT) {
			add = false;
		}
		return add;
	}
	public Ship(String name) {
		this.name = name;
		Aloads = new ArrayList <Load>();	
	}
	public String getName() {
		return name;
	}
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
	public String unloadShip(){
		String message = "";
		Aloads.clear();
		message = "Ship empty by method";
		return message;
	}	
	public boolean shipSail() {
		boolean toSail; 
		if((calculateTotalWeight()>=MINWEIGHT || Aloads.size() >= 2) && sanityCondition() == true && calculateTotalWeight()<=MAXWEIGHT){
			toSail = true;
		}else { 
			toSail = false;
		}
		return toSail;
	}
	public boolean sanityCondition() {
		boolean correct = true;
		for (int i = 0; i < Aloads.size(); i++) {
			for (int j = 1; j < Aloads.size(); j++) { 
				if((Aloads.get(i).getLoadType().equalsIgnoreCase("DANGEROUS") && Aloads.get(j).getLoadType().equalsIgnoreCase("PERISHABLE"))||(Aloads.get(i).getLoadType().equalsIgnoreCase("PERISHABLE")&&Aloads.get(j).getLoadType().equalsIgnoreCase("DANGEROUS")))
					correct = false;
			}     
		}return correct;
	}
	//	public String addClient(String name, int kgSent, String clientType, int register, int expDay, int expMonth, int expYear){
	//		String message = "";
	//		boolean ok = false;
	//		Client objSearch=searchClient(name);
	//		if(objSearch!=null)
	//			message="Client already exists";
	//		else 
	//		{
	//			for(int i = 0; i < clients.length && !ok; i++) {
	//				if(clients[i]==null) {
	//					clients[i]= new Client(name, kgSent, clientType, register, expDay,expMonth, expYear); {
	//						ok = true;
	//						message = "Client was added";
	//					}
	//				}	
	//				if(ok=false)
	//					message = "Client capacity was reached";
	//			}
	//		}
	//		return message;
	//	}
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