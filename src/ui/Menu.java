package ui;
import model.*;
import java.util.*;

public class Menu {

	//Attributes and constants declaration
	private Ship ship = new Ship("Morgan");
	private Client client;
	private final static int ADD_CLIENT_LOAD = 1;
	private final static int SAIL = 2;
	private final static int UNLOAD_SHIP = 3;
	private final static int SHOW_CLIENTS = 4;
	private final static int EXIT = 5;
	private final static int C1 = 1;
	private final static int C2 = 2;
	private final static int C3 = 3;
	private final static int C4 = 4;
	private final static int C5 = 5;


	//Methods

	/**
	 *This method initialize the menu.
	 *<b> <br>
	 *<b>post:</b> The Menu is ready.<br>
	 */
	public Menu() {
		this.ship = startShip();
	}
	/**
	 *This method initialize the ship.
	 *
	 *<b> <br>
	 *
	 *<b>post:</b> The ship is already created.<br>
	 *<b>post:</b> Returns ship.<br>
	 */
	public Ship startShip() {
		String name = "The Pirate";
		Ship ship = new Ship(name);
		System.out.println("****"+name+"****");
		return ship;
	}
	/**
	 *This method initialize the five clients and deploy it.
	 *<b>pre:</b> Ship already created.<br>
	 *
	 *<b>post:</b> The five clients are already created.<br>
	 */
	public void initializeClients() {
		ship.clients [0] = new Client("Juan", 0, "NORMAL", 0001,0, 20, 2,2020);
		ship.clients [1] = new Client("Rosa", 0, "NORMAL", 0002,0, 15, 1,2020);
		ship.clients [2] = new Client("Kevin", 0, "NORMAL", 0003,0, 2, 1, 2020);
		ship.clients [3] = new Client("Andres", 0, "NORMAL", 0004,0, 5, 2, 2020);
		ship.clients [4] = new Client("Camilo", 0, "NORMAL", 0005,0, 7, 3, 2020);
		System.out.println("Hello Morgan. Your clients are already created and are: \n"+"(1)"+ship.clients[0].getName()+"\n"+"(2)"+ship.clients[1].getName()+"\n"+"(3)"+ship.clients[2].getName()+"\n"+"(4)"+ship.clients[3].getName()+"\n"+"(5)"+ship.clients[4].getName()+"\n");
		System.out.println("Select option (4) if you want to show the complete information from them or continue adding loads \n");
	}
	/**
	 *This method show the five clients.
	 *<b>pre:</b> Clients are already created.<br>
	 *<b>pre:</b> Kilograms transported will be visible after ship sail (option "can the ship sail?") that means after complete the travel .<br>
	 *
	 *<b>post:</b> Show the five clients updated.<br>
	 */	
	public void showClients() {
		for (int i = 0; i < ship.clients.length; i++) {
			System.out.println("CLIENT #"+ (i+1) +"\n"+"Name: "+ship.clients[i].getName()+"\n"+""+"Kilograms transported: " + ship.clients[i].getKgSent() + "\n"+""+"Client type: "+ship.clients[i].getClientType()+"\n"+""+"Register number: "+ship.clients[i].getNumber()+"\n"+"Value paid is: "+ship.clients[i].getValuePaid()+"\n"+"Day: "+ship.clients[i].getDay()+"\n"+"Month: "+ship.clients[i].getMonth()+"\n"+"Year: "+ship.clients[i].getYear()+"\n");
		}
	}
	/**
	 *This method reads the entry data by the client and decide if the load can create or no.
	 *<b>pre:</b> Clients are already created. <br> 
	 *<b>pre:</b> Array of loads already initialize. <br> 
	 *
	 *<b>post:</b> Load is created or not, depend of the data entry of user. <br>
	 */
	public void readLoad() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entry boxes quantity");
		int boxes = sc.nextInt();
		System.out.println("Entry weight in grams per boxes");
		int x = sc.nextInt();
		int boxesWeight = x/1000;
		sc.nextLine();
		System.out.println("Please select load type");
		System.out.println("(1). Dangerous \n (2). Perishable \n (3). Not perishable");
		int type = sc.nextInt();
		sc.nextLine();
		String loadType;
		switch (type) {
		case 1:
			loadType = "DANGEROUS";
			System.out.println("Entry the owner");
			System.out.println("clients are: \n"+"(1)"+ship.clients[0].getName()+"\n"+"(2)"+ship.clients[1].getName()+"\n"+"(3)"+ship.clients[2].getName()+"\n"+"(4)"+ship.clients[3].getName()+"\n"+"(5)"+ship.clients[4].getName()+"\n");
			int g = sc.nextInt();
			sc.nextLine(); 
			String owner = switchMenuClients(g);
			if(boxesWeight > ship.MAXWEIGHT)
				System.out.println("Load cant be added due maximum load excess");
			else if((ship.calculateTotalWeight()+boxesWeight) > ship.MAXWEIGHT) {
				System.out.println("Load cant be added due maximum load excess");
			}
			else if(ship.addLoad()== false) {
				System.out.println("Load cant be added");
			} else {
				Load load = new Load(boxes, boxesWeight, loadType, owner); 
				ship.Aloads.add(load);
				System.out.println("Load added!");
			}
			break;
		case 2:
			loadType = "PERISHABLE";
			System.out.println("Entry the owner");
			System.out.println("clients are: \n"+"(1)"+ship.clients[0].getName()+"\n"+"(2)"+ship.clients[1].getName()+"\n"+"(3)"+ship.clients[2].getName()+"\n"+"(4)"+ship.clients[3].getName()+"\n"+"(5)"+ship.clients[4].getName()+"\n");
			int f = sc.nextInt();
			sc.nextLine(); 
			String owner2 = switchMenuClients(f);
			if(boxesWeight > ship.MAXWEIGHT)
				System.out.println("Load cant be added due maximum load excess");
			else if((ship.calculateTotalWeight()+boxesWeight) > ship.MAXWEIGHT) {
				System.out.println("Load cant be added due maximum load excess");
			}
			else if(ship.addLoad()== false) {
				System.out.println("Load cant be added");
			} else {
				Load load = new Load(boxes, boxesWeight, loadType, owner2); 
				ship.Aloads.add(load);
				System.out.println("Load added!");
			}
			break;
		case 3:
			loadType = "NOTPERISHABLE";
			System.out.println("Entry the owner");
			System.out.println("clients are: \n"+"(1)"+ship.clients[0].getName()+"\n"+"(2)"+ship.clients[1].getName()+"\n"+"(3)"+ship.clients[2].getName()+"\n"+"(4)"+ship.clients[3].getName()+"\n"+"(5)"+ship.clients[4].getName()+"\n");
			int v = sc.nextInt();
			sc.nextLine();
			String owner3 = switchMenuClients(v);
			if(boxesWeight > ship.MAXWEIGHT)
				System.out.println("Load cant be added due maximum load excess");
			else if((ship.calculateTotalWeight()+boxesWeight) > ship.MAXWEIGHT) {
				System.out.println("Load cant be added due maximum load excess");
			}
			else if(ship.addLoad()== false) {
				System.out.println("Load cant be added");
			} else {
				Load load = new Load(boxes, boxesWeight, loadType, owner3); 
				ship.Aloads.add(load);
				System.out.println("Load added!");
			}
			break;
		default:
			System.out.println("Please select a correct option");
			break;
		} 			
	}
	/**
	 *This is an auxiliary method for the method "readLoad".
	 *<b>pre:</b> Clients are already created. <br>
	 *<b>pre:</b> Select an option between 1 to 5. <br>
	 *
	 *@param g is the option of client  
	 *
	 *<b>post:</b> returns owner is the String of client name. <br>
	 */
	public String switchMenuClients(int g) {
		String owner = "";
		switch (g) {
		case 1:
			owner = ship.clients[0].getName();
			break;
		case 2:
			owner = ship.clients[1].getName();
			break;
		case 3:
			owner = ship.clients[2].getName();
			break;
		case 4:
			owner = ship.clients[3].getName();
			break;
		case 5:
			owner = ship.clients[4].getName();
			break;
		default: 
			System.out.println("Select a correct option");
			break;
		}
		return owner;
	}
	/**
	 *This method shows the Main menu.
	 *<b>pre:</b> <br>
	 *
	 *<b>post:</b> shows the options. <br>
	 */
	public void showMenu() {
		System.out.println("********MENU********");
		System.out.println();
		System.out.println(" (1). Add load to a client\n (2). Can the ship sail?\n (3). If you want to **unload ship manual**, select this option\n (4). Show clients\n (5). Exit\n ");
	}
	/**
	 *This method shows the value to paid for the client that the user choose.
	 *<b>pre:</b>A client must has a load as minimum. <br>
	 *<b>pre:</b> Select an option between 1 to 5. <br>
	 *
	 *<b>post:</b>Show the value to paid for the client that user elected. <br>
	 */
	public void toPaid() {
		Scanner sc = new Scanner(System.in);
		int choice; 
		System.out.println("Select the client to know value to paid");
		System.out.println();
		System.out.println("(1)."+ship.clients[0].getName()+"\n"+"(2)."+ship.clients[1].getName()+"\n"+"(3)."+ship.clients[2].getName()+"\n"+"(4)."+ship.clients[3].getName()+"\n"+"(5)."+ship.clients[4].getName()+"\n");
		choice = sc.nextInt();
		switch (choice) {
		case C1:
			for (int i = 0; i < ship.Aloads.size(); i++) {
				if(ship.Aloads.get(i).getOwner().equals(ship.clients[0].getName()))
					System.out.println("For the load of type: "+ship.Aloads.get(i).getLoadType()+" You must pay: "+ship.calculateParcialValue(ship.totalKgSentClient(ship.clients[0].getName()), ship.Aloads.get(i).getLoadType()));
			}
			break;
		case C2:
			for (int i = 0; i < ship.Aloads.size(); i++) {
				if(ship.Aloads.get(i).getOwner().equals(ship.clients[1].getName()))
					System.out.println("For the load of type: "+ship.Aloads.get(i).getLoadType()+" You must pay: "+ship.calculateParcialValue(ship.totalKgSentClient(ship.clients[1].getName()), ship.Aloads.get(i).getLoadType()));
			}
			break;
		case C3:
			for (int i = 0; i < ship.Aloads.size(); i++) {
				if(ship.Aloads.get(i).getOwner().equals(ship.clients[2].getName()))
					System.out.println("For the load of type: "+ship.Aloads.get(i).getLoadType()+" You must pay: "+ship.calculateParcialValue(ship.totalKgSentClient(ship.clients[2].getName()), ship.Aloads.get(i).getLoadType()));
			}
			break;

		case C4:
			for (int i = 0; i < ship.Aloads.size(); i++) {
				if(ship.Aloads.get(i).getOwner().equals(ship.clients[3].getName()))
					System.out.println("For the load of type: "+ship.Aloads.get(i).getLoadType()+" You must pay: "+ship.calculateParcialValue(ship.totalKgSentClient(ship.clients[3].getName()), ship.Aloads.get(i).getLoadType()));
			}
			break;
		case C5:
			for (int i = 0; i < ship.Aloads.size(); i++) {
				if(ship.Aloads.get(i).getOwner().equals(ship.clients[4].getName()))
					System.out.println("For the load of type: "+ship.Aloads.get(i).getLoadType()+" You must pay: "+ship.calculateParcialValue(ship.totalKgSentClient(ship.clients[4].getName()), ship.Aloads.get(i).getLoadType()));
			}
			break;
		default: System.out.println("Select a correct option");
		break;
		}
	}
	/**
	 *This method read the option entry by the client for the Main menu.
	 *<b>pre:</b>Select an option between 1 to 8. <br>
	 *
	 *<b>post:</b><br>
	 */
	public int readOption() {
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		sc.nextLine();
		System.out.println();
		return choice;
	}
	/**
	 *This method analize the position of the array list of loads.
	 *<b>pre:</b>A load was created as minimum. <br>
	 *
	 *<b>post:</b>Returns the position of the loads array. <br>
	 */
	public int occupatePosition() {
		int a = -1;
		for (int i = 0; i < ship.Aloads.size(); i++) {
			if(ship.Aloads.get(i)!=null)
				a++;
		}
		return a;
	}
	/**
	 *This is method calculate the value to paid by client depend of the client type and apply the discount.
	 *
	 *<b>pre:</b>A load for a client was created as minimum. <br>
	 *
	 *@param x is the result of parcial value to pay
	 *@param loadType is the type of load
	 *
	 *<b>post:</b> Returns x is the operation of apply the discount. <br>
	 */
	public void valuePaidDueType() {
		double x = 0.0;
		for (int i = 0; i < ship.clients.length; i++) {
			for (int j = 0; j < ship.Aloads.size(); j++) {
				x = ship.calculateTotalValuePaid(ship.calculateParcialValue(ship.totalKgSentClient(ship.clients[i].getName()), ship.Aloads.get(occupatePosition()).getLoadType()), ship.clients[i].getClientType(), ship.Aloads.get(j).getLoadType());
			}
			ship.totalValuePaidAccumulate(x, ship.clients[i].getName());
		}
	}
	/**
	 *This method is a switch that allows entering the options of the Main menu by an user selection.
	 *<b>pre:</b>Clients are already created.<br>
	 *
	 *<b>post:</b>Redirect to the entered option. <br>
	 *@param choice is the option by the user
	 */
	public void operation(int choice) {
		switch(choice) {
		case SHOW_CLIENTS:
			showClients();
			break;
		case ADD_CLIENT_LOAD :
			readLoad();
			break;
		case SAIL:
			if(ship.shipSail() == false) {
				System.out.println("Ship cant sail \n Please check the conditions of loads \n");
			}
			else if(ship.shipSail() == true) {
				System.out.println("Ship can sail \n **The ship has been unloaded and the load history per customer saved** :) \n");
				for (int i = 0; i < ship.clients.length; i++) {
					int x = ship.totalKgSentClient((ship.clients[i].getName()));
					ship.totalAccumulate(x, ship.clients[i].getName());
				}
				boolean x = false;

				for (int i = 0; i < ship.clients.length; i++) {
					x = ship.calculateClientType(ship.clients[i].getKgSent(), ship.clients[i].getValuePaid(), i);
					String message = ship.notifyNewClientType(x, i);
					System.out.println(message);

				}
				valuePaidDueType();
				ship.unloadShip();
				System.out.println(ship.unloadShip());
			}
			break;
		case UNLOAD_SHIP:
			String x = ship.unloadShip();
			System.out.println(x);
			break;
		case EXIT:
			break;
		default:
			System.out.println("****Select a correct choice****");
			break;
		}
	}
	/**
	 *This method starts the program and keeps showing the Main menu until user select option "EXIT".
	 *<b>pre:</b>.<br>
	 *
	 *<b>post:</b>the program starts and the clients are initialized and show menu . <br>
	 */
	public void startProgram() {
		int option;
		initializeClients();
		do {
			showMenu();
			option = readOption();
			operation(option);
		} while(option!=EXIT);
	}
}