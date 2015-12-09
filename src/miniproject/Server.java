package miniproject;

import java.io.*;
import java.net.*;
import java.util.*;

// General server code.

public class Server {
	
//	TODO: Set up Port and ServerSocket
	public static ServerSocket serverserver;
	public static final int PORT=15333;
	
	public static void main(String[] args) throws IOException{
try{	
	serverserver = new ServerSocket(PORT);	
}
	catch(IOException ioEx){
		System.out.println("\nCannot connected to the server on the specific port!");
		System.exit(1);
	}
do{
	Socket system = serverserver.accept();
	System.out.println("\nYou are connected to the specific port!");
	ClientHandlerIn getmyinfo = new ClientHandlerIn(system);
	getmyinfo.start();
}while(true);
//		TODO: Try/catch: Connect serverSocket to port.
		
//		TODO: do/while(true): Wait for clients to connect, then start ClientHandlerIn thread
	}
	public void ClientOut(){
		try{
			serverserver=new ServerSocket(PORT);
		} 
		catch(IOException ioEx){
			System.out.println("\nCannot connected to the server on the specific port!");
			System.exit(1);
		}
		do{
		Socket system = serverserver.accept();
		ClientHandlerOut whatshouldmacallit = new ClientHandlerOut(system);
		whatshouldmacallit.start();
	}while(true);
	
//	TODO: Start ClientHandlerOut thread. Talk with whoever is programming that part, to figure out how you wanna do this.
	}
