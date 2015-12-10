package miniproject2test;

import java.io.*;
import java.net.*;
import java.util.*;


public class ClientHandler extends Thread {

	Socket client;
	
	ClientHandler (Socket socket){
		this.client = socket;
	}
	
	public void run(){
		
		Scanner scanner = null;
		String received;
		
		try{
			scanner = new Scanner(client.getInputStream());
			received = scanner.nextLine();
		}catch(IOException ioEx){
			ioEx.printStackTrace();
		}
	}
	
}
