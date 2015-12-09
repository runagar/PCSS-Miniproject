package miniproject;

import java.io.*;
import java.net.*;
import java.util.*;

/*import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHandler extends Thread {
    private Socket client;
    private Scanner input;
    private PrintWriter output;
    
    // INPUT CLIENT HANDLER //
    public ClientHandler(Socket socket){
        client = socket;
        try{
            input = new Scanner(client.getInputStream());
        }
        catch(IOException ioEx){
            ioEx.printStackTrace();
        }
    }
    
    // OUT CLIENT HANDLER //
    public ClientHandler(Socket socket){
        client = socket;
        try{
            output = new PrintWriter(client.getOutputStream(),true);
        }
        catch(IOException ioEx){
            ioEx.printStackTrace();
        }
    } 
     

	// 
    public void run(){
        String received;
        do{
            received = input.nextLine();
        } while (!received.equals("QUIT"));
        
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
*/

//Class for handling the server-input. Meaning, setting up connection with "ClientSender" class, and receiving input.

public class ClientHandlerIn extends Thread {

//  TODO: Set up private variables: Socket, Scanner.
	
//	Constructor:
	public ClientHandlerIn(Socket socket){
		
//		TODO: Define Socket.
//		TODO: Set up Scanner to inputStream. (So it listens to input)(remember try/catch method).
	}
	
	public void run(){
//		TODO: Save nextLine from inputStream as string.
//		TODO: Find a way to send input String to ClientHandlerOut via Server class
//		TODO: Set up conditions for when the connection should close.
	}
}
