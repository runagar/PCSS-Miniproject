package miniproject;

import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHandlerIn extends Thread {
	
//  set up variables: Socket, Scanner.
    public Socket client;
    private Scanner input;
    static int clientNumber = 0;
    int ID;
    
   //	constructor
    public ClientHandlerIn(Socket socket){
    	
        //	Initialise Socket.
    	client = socket;
    	ID = clientNumber++;
        
        //	sets up a Scanner to InputStream; looks out for input
        try{
            input = new Scanner(client.getInputStream());
        }
        catch(IOException ioEx){
            ioEx.printStackTrace();
        }
    }

    //	saves nextLine from inputStream as string
    public void run(){
    	String received;
        do{
        	//received is to be read by ClientHandlerOut
            received = input.nextLine();
            System.out.println("\nMessage received");
            
        } while (!received.equals("QUIT"));
        
        
       //	conditions for closing the connection    
        try{
            if(client!=null){
                System.out.println("Closing connection ...");
                client.close();
            }
        }
        catch (IOException ioEx){
            System.out.println("Unable to disconnect!");
            
        }
    } 

}

