package miniproject;

import java.io.*;
import java.net.*;
import java.util.*;


public class ClientSender {
	private static Scanner inputScanner;
	private static String input;                        
	private static Socket socket;
	private static final int PORT = 15333;
	private static InetAddress address;
	private static PrintWriter printWriter;
	
	private static void sendMessages(){
		try{ 
			socket = new Socket(address, PORT);
			printWriter.println();
			
			do{
				input = inputScanner.nextLine();
				printWriter = new PrintWriter(socket.getOutputStream());
			} while(input != "QUIT");
		}catch(IOException ioEx){
			ioEx.printStackTrace();
		}
		finally{
			try{
				System.out.println("Closing connection...");
				socket.close();
			}
			catch(IOException IOEx){
				System.out.println("Unable to close connection!");
				System.exit(1);
			}
		}
	}
	
	public static void main(String[] args){
		try{
			address = InetAddress.getLocalHost();
		}
		catch(UnknownHostException unEx){
			System.out.println("Cannot find host!");
		}
		sendMessages();
	}	
}
