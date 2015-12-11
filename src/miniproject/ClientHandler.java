package miniproject;

import java.io.*;
import java.net.*;
import java.util.*;


public class ClientHandler extends Thread {

//	Declare socket.
	Socket client;
	
//	Constructor
	ClientHandler (Socket socket){
		this.client = socket;
	}
	
//	run method
	public void run(){
		
//		Initialise scanner and string for incoming messages.
		Scanner scanner = null;
		String received = "";
		
//		Set the scanner up to listen for incoming messages.
		try{
			scanner = new Scanner(client.getInputStream());
			
//			Set the string to be the next incoming message. Start a thread handling the message.
			do{
				received = scanner.nextLine();
				
				if(!received.equals("QUIT")){
					System.out.println("\nMessage received. Processing . . .");
					new SortAndSend(client, received).start();
				}
			}while(!received.equals("QUIT"));
			
		}catch(IOException ioEx){
			ioEx.printStackTrace();
		}
		
//		Once the QUIT message is received
		finally{
			
//			Close the scanner and socket.
			scanner.close();
			try{
				System.out.println("\nDisconnecting client. . .");
				client.close();
				System.out.println("Disconnect successful.");
			}catch(IOException ioEx){
				System.out.println("Could not disconnect socket!");
				System.exit(1);
			}
		}
	}
}
