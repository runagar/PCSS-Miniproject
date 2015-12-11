package miniproject;

import java.io.*;
import java.net.*;
import java.util.*;

public class ClientReceiver {
	
//	Initialise PORT and declare InetAddress for the host.	
	private static InetAddress link;
	private static final int port = 15333;
	
	public static void main(String[] args){
		
//		Find the host
		try{									
			link = InetAddress.getLocalHost();						
			
		}catch(UnknownHostException uhEx){
			System.out.println("Host not found!");
		}
		
		receiveMessages();
	}
	
	public static void receiveMessages(){
		
//		Initialise socket and scanner.
		Socket socket = null;
		Scanner inputScanner = null;
		
//		Establish connection to host.
		try{
			System.out.println("Connecting . . .");
			socket = new Socket(link, port);
			System.out.println("Connected.");
			
//			Set scanner to listen for input from the server. Declare string variable to hold this input.
			inputScanner = new Scanner(socket.getInputStream());
			String input;
			
//			Set string to be equal to the input received from server. Print the input.
			do{
				input = inputScanner.nextLine();
				System.out.println("\nMessage received:");
				System.out.println(input);
			}while(true);
			
		}catch(IOException ioEx){
			ioEx.printStackTrace();
			System.exit(1);
		}
	}
}
