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
	
	serverserver = new ServerSocket(PORT);	
	
//		TODO: Try/catch: Connect serverSocket to port.
		
//		TODO: do/while(true): Wait for clients to connect, then start ClientHandlerIn thread
	}

//	TODO: Start ClientHandlerOut thread. Talk with whoever is programming that part, to figure out how you wanna do this.
}
