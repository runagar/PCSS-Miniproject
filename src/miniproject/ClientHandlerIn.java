package miniproject;

import java.io.*;
import java.net.*;
import java.util.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHandlerIn extends Thread {
	
//  set up variables: Socket, Scanner.
	
    public Socket client;
    public Scanner input;
    
   //	constructor
    public ClientHandlerIn(Socket socket){
    	
        //	defines Socket.
    	client = socket;
        
        //	sets up a Scanner to inputStream; looks out for input
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
            received = input.nextLine();
            
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

