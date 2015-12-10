package miniproject;

import java.io.*;
import java.net.*;
import java.util.*;

// General server code.

public class Server {
	
//	TODO: Set up Port and ServerSocket
	public static ServerSocket serverserver;
	public static final int PORT = 15333;
	public static String receivedString= "";
	
	public static void main(String[] args) throws IOException{
		int clientNum = 0;
		ArrayList clients = new ArrayList();
		
		try{	
			System.out.println("\nOpening Server . . ." );
			serverserver = new ServerSocket(PORT);	
		}
		catch(IOException ioEx){
				System.out.println("\nUnable to set up port.");
				System.exit(1);
		}
		
		do{
			Socket clientSocket = serverserver.accept();
			clientNum++;
			System.out.println("\nClient #"+ clientNum +" accepted!");
			ClientHandlerIn client = new ClientHandlerIn(clientSocket);
			clients.add(client);
		} while(true);
	}
}
