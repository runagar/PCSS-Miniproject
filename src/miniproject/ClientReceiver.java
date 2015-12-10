package miniproject;

import java.io.*;
import java.net.*;
import java.util.*;

// ClientReceiver class. Receives messages from the server. 

public class ClientReceiver {	
//	Setting up port and server address.				
	static InetAddress link;						//declaring InetAddress called link
	static final int port = 15333;					//initialising port to 15333 										 
	
	public static void main(String[] args){							//main method
		//finding host and connecting
		try{								
			System.out.println("Connecting . . .");
			link = InetAddress.getLocalHost();						//link = ...
			System.out.println("Connected.");
			
		}catch(UnknownHostException uhEx){							//if this can't then, system is caught by UnknownHostException
			System.out.println("Host not found!");					//prints out "..." in the console. 
		}
		receiveMessages();											//calls method 'receiveMessages'
	}
	
	public static void receiveMessages(){
		Socket socket = null;	//creating new Socket Object
		
		try{
			socket = new Socket(link, port);							//initializing socket.
			Scanner inputScanner = new Scanner(socket.getInputStream()); //Setting up Scanner to listen for anything that happens in the socket.
			String input;			//declaring String 'input'.	
			
			do{
				input = inputScanner.nextLine();					//input is set to be whatever the Scanner gets. 
				System.out.println("\nMessage receive");
				System.out.println(input);							//then prints the String 'input' into the console.
				
			}while(true);
			
		}catch(IOException ioEx){									//the system is caught by an IOException.
			ioEx.printStackTrace();									//prints what happens.
			System.exit(1);											//exits system - 1 means that the exit of the system was unintended.
		}
	}
}
