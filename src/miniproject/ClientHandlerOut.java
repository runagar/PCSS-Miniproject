package miniproject;

import java.io.*;
import java.net.*;
import java.util.*;

// Class for handling the server-output which is sent to "ClientReceiver" class.

public class ClientHandlerOut extends Thread {
	
	Socket client;
	PrintWriter output;
	ArrayList<Node> list;
	
//	Constructor:
	public ClientHandlerOut(Socket socket){
		client = socket;
		try{
			output = new PrintWriter(client.getOutputStream(), true);
		}
		catch(IOException ioEx){
			ioEx.printStackTrace();
		}
	}
	
	public void run(String string){
		
		String word = "";
		
		for(int i = 0; i < string.length(); i++){
			if(string.charAt(i) == (' ')){
				if(!word.equals("")){
					Node node = new Node(word);
					word = "";
					for(int j = 0; j < list.size(); j++){
						if(list.get(j).Equals(node)){
							break;
						}
						else if(j == list.size()-1){
							list.add(node);
						}
					}
				}
				continue;
			}
			else{
				word = word + string.charAt(i);
			}
		}
		
		boolean sort = true;
		while(sort){
			sort = false;
			for(int i = 0; i < list.size(); i++){
				if(list.get(i).hasMoreOccurrencesThan(list.get(i+1))){
					Node temp = list.get(i);
					list.set(i, list.get(i+1));
					list.set(i+1, temp);
					sort = true;
				}
			}
		}
		
		String outputString = list.toString();
		
		output.println(outputString);
		System.out.println("\nMessage returned");
		
//		TODO: Compare words in the String to previous words.
//		HINT: Save new words as Nodes in an arrayList. Compare new words to all words in the list 
//		before making nodes out of them. We don't want the same word as two separate nodes.
		
//		TODO: Sort the arrayList so that words with higher occurrences comes first, using any sorting algorithm you wish.
		
//		TODO: Send arrayList of words as String to ClientReceiver via PrintWriter.
	}

	public void start(String received) {
		run(received);
		
	} 
}
