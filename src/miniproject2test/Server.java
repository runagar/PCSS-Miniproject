package miniproject2test;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
	
	private static ServerSocket serverSocket;
    private static final int PORT = 15333;
    
    static ArrayList clients = new ArrayList();
    
	public static void main(String args[]) throws IOException{
		try{
			serverSocket = new ServerSocket(PORT);
		}catch(IOException ioEx){
			ioEx.printStackTrace();
			System.exit(1);
		}
		do{
			Socket client = serverSocket.accept();
            System.out.println("\nNew client accepted.\n");
            ClientHandler ch = new ClientHandler(client);
            clients.add(ch);
            ch.start();
		}while(true);
	}
}