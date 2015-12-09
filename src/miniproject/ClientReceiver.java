package miniproject;

import java.io.*;
import java.net.*;
import java.util.*;

// ClientReceiver class. Receives messages from the server. 

public class ClientReceiver {	
//	Setting up port and server address.
	static Socket socket;											//creating new Socket Object
	static InetAddress link;										//declaring InetAddress called link
	static final int port = 15333;									//initializing port to 15333
	static Scanner inputScanner; 									//declaring Scanner
	static String input;											//declaring String 'input'. 
	
	public static void main(String[] args){							//main method
		//finding host and connecting
		try{														//try catch function
			link = InetAddress.getLocalHost();						//link = ...
		}catch(UnknownHostException uhEx){							//if this can't then, system is caught by UnknownHostException
			System.out.println("Host not found!");					//prints out "..." in the console. 
		}
		receiveMessages();											//calls method 'receiveMessages'
	}
	
	public static void receiveMessages(){
		
		try{
			socket = new Socket(link,port);							//initializing socket.
			inputScanner = new Scanner(socket.getInputStream()); 	//Setting up Scanner to listen for anything that happens in the socket.
			
			do{
				input = inputScanner.nextLine();					//input is set to be whatever the Scanner gets. 
				System.out.println(input);							//then prints the String 'input' into the console.
				
			}while(true);
			
		}catch(IOException ioEx){									//the system is caught by an IOException.
			ioEx.printStackTrace();									//prints what happens.
			System.exit(1);											//exits system - 1 means that the exit of the system was unintended.
		}
	}
}
