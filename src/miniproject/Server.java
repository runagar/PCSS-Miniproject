package miniproject;

import java.io.*;
import java.net.*;
import java.util.*;

// General server code.

public class Server {
	
	//	TODO: Set up Port and ServerSocket
		public static ServerSocket serverserver;
		public static final int PORT = 15333;
		
		public static void main(String[] args) throws IOException{
	try{	
		System.out.println("\nOpening Server . . ." );
		serverserver = new ServerSocket(PORT);	
	}
		catch(IOException ioEx){
			System.out.println("\nUnable to set up port.");
			System.exit(1);
		}
	do{
		System.out.println("\nServer open.");
		
		Socket client = serverserver.accept();
		
		System.out.println("\nYou are connected to the specific port!");
		ClientHandlerIn receiver = new ClientHandlerIn(client);
		receiver.start();
		}while(true);
	}
}
