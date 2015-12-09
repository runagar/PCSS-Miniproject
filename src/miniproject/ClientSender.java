package miniproject;

import java.io.*;
import java.net.*;
import java.util.*;


public class ClientSender {                
	private static final int PORT = 15333;
	private static InetAddress address; 
	
	private static void sendMessages(){
		Socket socket = null;
		try{ 
			
			System.out.println("\nConnecting . . .");
			socket = new Socket(address, PORT);
			System.out.println("\nConnected");
			
			Scanner inputScanner = new Scanner(System.in);
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
			String input; 
			do{
				System.out.println("\nEnter Message. ('QUIT' to exit)");
				input = inputScanner.nextLine();
				printWriter = new PrintWriter(socket.getOutputStream());
				printWriter.println(input);
				System.out.println("\nMessage Sent");
			} while(input != "QUIT");
		}catch(IOException ioEx){
			ioEx.printStackTrace();
		}
		finally{
			try{
				System.out.println("\nClosing connection...");
				socket.close();
			}
			catch(IOException IOEx){
				System.out.println("\nUnable to close connection!");
				System.exit(1);
			}
		}
	}
	
	public static void main(String[] args){
		try{
			address = InetAddress.getLocalHost();
		}
		catch(UnknownHostException unEx){
			System.out.println("\nCannot find host!");
		}
		sendMessages();
	}	
}
