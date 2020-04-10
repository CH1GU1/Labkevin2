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
	private final static int MODIFY_CATEGORY = 4; 
	private final static int SHOW_KG_BY_CLIENT = 5;
	private final static int VALUE_PAID = 6;
	private final static int SHOW_CLIENTS = 7;
	private final static int EXIT = 8;
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
		ship.clients [0] = new Client("Juan", 0, "NORMAL", 0001, 20, 2,2020);
		ship.clients [1] = new Client("Rosa", 0, "NORMAL", 0002, 15, 1,2020);
		ship.clients [2] = new Client("Kevin", 0, "NORMAL", 0003, 2, 1, 2020);
		ship.clients [3] = new Client("Andres", 0, "NORMAL", 0004, 5, 2, 2020);
		ship.clients [4] = new Client("Camilo", 0, "NORMAL", 0005, 7, 3, 2020);
		System.out.println("Hello Morgan. Your clients are already created and are: \n"+"(1)"+ship.clients[0].getName()+"\n"+"(2)"+ship.clients[1].getName()+"\n"+"(3)"+ship.clients[2].getName()+"\n"+"(4)"+ship.clients[3].getName()+"\n"+"(5)"+ship.clients[4].getName()+"\n");
		System.out.println("Select option 7. to show the complete information from them or continue adding loads \n");
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
			System.out.println("CLIENT #"+ (i+1) +"\n"+"Name: "+ship.clients[i].getName()+"\n"+""+"Kilograms transported: " + ship.clients[i].getKgSent() + "\n"+""+"Client type: "+ship.clients[i].getClientType()+"\n"+""+"Register number: "+ship.clients[i].getNumber()+"\n"+"Day: "+ship.clients[i].getDay()+"\n"+"Month: "+ship.clients[i].getMonth()+"\n"+"Year: "+ship.clients[i].getYear()+"\n");
		}
	}
	/**
	 *This method reads the entry data by the client and decide if the load can create or no.
	 *<b>pre:</b> Clients are already created. <br> 
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
		System.out.println(" (1). Add load to a client\n (2). Can the ship sail?\n (3). If you want to **unload ship manual**, select this option\n (4). Modify client category\n (5). Show kilograms transported by client\n (6). Show value paid by client\n (7). Show clients\n (8). Exit\n ");
	}
	/**
	 *This method shows the historical kilograms sent by clients.
	 *<b>pre:</b>The ship made minimum one travel. <br>
	 *<b>pre:</b>A client made a load and the was sail. <br>
	 *
	 *<b>post:</b> A historical charge of a clients was saved. <br>
	 */
	public void toShowKgClient() {
		for (int i = 0; i < ship.clients.length; i++) {
			String name = ship.clients[i].getName();
			int z = ship.totalKgSentClient(name);
			ship.totalAccumulate(z, name);
			System.out.println("The kilograms accumlated at this moment by "+ship.clients[i].getName()+" are "+ship.clients[i].getKgSent()+"\n");
		}
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
	 *This method makes the modification of category of the clients.
	 *<b>pre:</b>A load of client has taken at least one travel and meet the conditions to be upgraded. <br>
	 *<b>pre:</b> Select an option between 1 to 5. <br>
	 *
	 *<b>post:</b>Show if the client could be upgraded or not, is yes will show the new category. <br>
	 */
	public void toModify() {
		Scanner sc = new Scanner(System.in);
		System.out.println("For modify client category please select one of the five clients \n");
		System.out.println();
		System.out.println("(1)."+ship.clients[0].getName()+"\n"+"(2)."+ship.clients[1].getName()+"\n"+"(3)."+ship.clients[2].getName()+"\n"+"(4)."+ship.clients[3].getName()+"\n"+"(5)."+ship.clients[4].getName()+"\n");
		int n = sc.nextInt();
		boolean x = false;
		switch (n) {
		case C1:
			for (int i = 0; i < ship.Aloads.size(); i++) {
				x = ship.calculateClientType(ship.clients[0].getKgSent(), ship.calculateTotalValuePaid(ship.calculateParcialValue(ship.totalKgSentClient(ship.clients[0].getName()), ship.Aloads.get(occupatePosition()).getLoadType()), ship.clients[0].getClientType()), 0);
			}
			String message0 = ship.notifyNewClientType(x, 0);
			System.out.println(message0);
			break;
		case C2:
			for (int i = 0; i < ship.Aloads.size(); i++) {
				x = ship.calculateClientType(ship.clients[1].getKgSent(), ship.calculateTotalValuePaid(ship.calculateParcialValue(ship.totalKgSentClient(ship.clients[1].getName()), ship.Aloads.get(occupatePosition()).getLoadType()), ship.clients[1].getClientType()), 1);
			}
			String message1 = ship.notifyNewClientType(x, 1);
			System.out.println(message1);
			break;
		case C3:
			for (int i = 0; i < ship.Aloads.size(); i++) {
				x = ship.calculateClientType(ship.clients[2].getKgSent(), ship.calculateTotalValuePaid(ship.calculateParcialValue(ship.totalKgSentClient(ship.clients[2].getName()), ship.Aloads.get(occupatePosition()).getLoadType()), ship.clients[2].getClientType()), 2);
			}
			String message2 = ship.notifyNewClientType(x, 2);
			System.out.println(message2);
			break;
		case C4:
			for (int i = 0; i < ship.Aloads.size(); i++) {
				x = ship.calculateClientType(ship.clients[3].getKgSent(), ship.calculateTotalValuePaid(ship.calculateParcialValue(ship.totalKgSentClient(ship.clients[3].getName()), ship.Aloads.get(occupatePosition()).getLoadType()), ship.clients[3].getClientType()), 3);
			}
			String message3 = ship.notifyNewClientType(x, 3);
			System.out.println(message3);
			break;
		case C5:
			for (int i = 0; i < ship.Aloads.size(); i++) {
				x = ship.calculateClientType(ship.clients[4].getKgSent(), ship.calculateTotalValuePaid(ship.calculateParcialValue(ship.totalKgSentClient(ship.clients[4].getName()), ship.Aloads.get(occupatePosition()).getLoadType()), ship.clients[4].getClientType()), 4);
			}
			String message4 = ship.notifyNewClientType(x, 4);
			System.out.println(message4);
			break;
		default: 
			System.out.println("****Please select a correct option****");
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
					x = ship.calculateClientType(ship.clients[i].getKgSent(), ship.calculateTotalValuePaid(ship.calculateParcialValue(ship.totalKgSentClient(ship.clients[i].getName()), ship.Aloads.get(occupatePosition()).getLoadType()), ship.clients[i].getClientType()), i);
					String message = ship.notifyNewClientType(x, i);
					System.out.println(message);

				}

				ship.unloadShip();
				System.out.println(ship.unloadShip());
			}
			break;
		case UNLOAD_SHIP:
			String x = ship.unloadShip();
			System.out.println(x);
			break;
		case MODIFY_CATEGORY:
			toModify();
			break;
		case SHOW_KG_BY_CLIENT:
			toShowKgClient();
			break;
		case VALUE_PAID:
			toPaid();
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