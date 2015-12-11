package miniproject;

import java.io.*;
import java.net.*;
import java.util.*;

public class ClientSender {                
	
//	Initialise PORT and declare InetAddress for the host.
	private static final int PORT = 15333;
	private static InetAddress address; 
	
	private static void sendMessages(){
		
//		Initialise Socket, Scanner and PrintWriter.
		Socket socket = null;
		Scanner inputScanner = null;
		PrintWriter printWriter = null;
		
//		Connect to the host.
		try{ 
			System.out.println("\nConnecting . . .");
			socket = new Socket(address, PORT);
			System.out.println("\nConnected");
			
//			Set scanner to listen for console input, set up PrintWriter to send messages to the host.
			inputScanner = new Scanner(System.in);
			printWriter = new PrintWriter(socket.getOutputStream(), true);
			String input; 
			
//			Catch user input. Send input string to host.
			do{
				System.out.println("\nEnter Message. ('QUIT' to exit)");
				input = inputScanner.nextLine();
				printWriter.println(input);
				System.out.println("\nMessage Sent");
			} while(!input.equals("QUIT"));
		}catch(IOException ioEx){
			ioEx.printStackTrace();
		}
		
//		If message it QUIT, shut down the connection and system.
		finally{
			try{
				inputScanner.close();
				System.out.println("\nClosing connection...");
				socket.close();
			}
			catch(IOException IOEx){
				System.out.println("\nUnable to close connection!");
				System.exit(1);
			}
			System.exit(0);
		}
	}
	
	public static void main(String[] args){
		
//		Find the host.
		try{
			address = InetAddress.getLocalHost();
		}
		catch(UnknownHostException unEx){
			System.out.println("\nCannot find host!");
		}
		
		sendMessages();
	}	
}
