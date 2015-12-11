package miniproject;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
	
//	Initialise ServerSocket and PORT
	private static ServerSocket serverSocket;
    private static final int PORT = 15333;
    
//  Initialise an empty ArrayList which is supposed to hold all the client threads.
    static ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>();
    
	public static void main(String args[]) throws IOException{
		
//		Try to open the ServerSocket in the PORT
		try{
			System.out.println("\nOpening port . . .");
			serverSocket = new ServerSocket(PORT);
		}catch(IOException ioEx){
			System.out.println("\nUnable to open port!");
			System.exit(1);
		}
		System.out.println("\nPort Open.\n");
		
//		Accept client connections. Start a thread for each client. Add the client thread to the ArrayList
		do{
			Socket client = serverSocket.accept();
            System.out.println("New client accepted.");
            ClientHandler ch = new ClientHandler(client);
            clients.add(ch);
            ch.start();
		}while(true);
	}
}