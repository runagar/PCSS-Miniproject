package miniproject;

import java.io.*; 
import java.net.*;
import java.util.*;

public class SortAndSend extends Thread {

//	Declare socket and String variables. Initialise an ArrayList to hold Nodes.
	Socket socket;
	String string;
	static ArrayList<Node> words = new ArrayList<Node>();
	
//	Constructor
	SortAndSend(Socket socket, String string){
		this.socket = socket;
		this.string = string;
	}
	
	public void run(){
//		Initialise an ArrayList holding all the characters in messages.
		ArrayList<Character> message = new ArrayList<Character>();
		
//		Initialise String. This will hold the current word in the input string.
		String word = "";
		
//		Initialise the string that is going to be sent as output to clients.
		String sender = "";
		
//		Add every character in the input string to the ArrayList
		for(int i = 0; i < string.length(); i++){
			message.add(string.charAt(i));
		}
		
//		Convert all upperCase characters to their lowerCase equivalent.
		for(int i = 0; i < message.size(); i++){
			message.set(i, Character.toLowerCase(message.get(i)));
		}
		
//		For every character in the array list:
		for(int i = 0; i < message.size(); i++){
			
//			If it is any type of whitespace.
			if(message.get(i) == ' ' || message.get(i) == '\t' || message.get(i) == '\r' || message.get(i) == '\n'){
				
//				And if "word" String is not empty.
				if(!word.equals("")){
					
//					Create a new node with that word, and clear current word String.
					Node node = new Node(word);
					word = "";
					
//					Call the addNode method.
					addNode(node);
					
				}
//				If word String IS empty, continue.
				continue;
			}
			
//			Otherwise, if the current character it NOT a whitespace, check if it's the last character in the input string.
			else if(i == message.size() - 1){
				
//				If the current char is a letter between a and z, add it to the word String.
				if(message.get(i) >= 'a' && message.get(i) <= 'z'){
					word = word + message.get(i);
				}
				
//				Create a new node with the word String, and clear word String.
				Node node = new Node(word);
				word = "";
				
//				Call the addNode method.
				addNode(node);
			}
			
//			If the current char is neither a whitespace or the last char in the string, add it to the current word if it's a letter between a and z.
			else{
				if(message.get(i) >= 'a' && message.get(i) <= 'z'){
					word = word + message.get(i);
				}
			}
		}

//		Sort the ArrayList of words.
		sortList();

//		Generate the output string and Send the message.
		sendMessage(generateOutputString());
	}
	
	public void sendMessage(String string){
		
//		Initialise the PrintWriter to send messages to the clients.
		PrintWriter print = null;
		
//		For every client connected to the server that DID NOT send the message.
		for(int i = 0; i < Server.clients.size(); i++){
			if(Server.clients.get(i).client == socket){
				continue;
			}
			
//			Set the PrintWriter up to print to that client.
			try{
				print = new PrintWriter(Server.clients.get(i).client.getOutputStream(), true);
			}catch(IOException ioEx){
				ioEx.printStackTrace();
			}
			
//			Send the string.
			print.println(string);
		}
	}
	
	public String generateOutputString(){
		
//		Initialise string.
		String sender = "";
		
//		Add all nodes in the list to the string via their toString method.
		for(int i = 0; i < words.size(); i++){
			if(sender.equals("")){
				sender = words.get(i).toString();
				continue;
			}
			sender += "  ;  " + words.get(i).toString();
		}
		
		return sender;
	}
	
	public void sortList(){
		boolean flag = true;
		
//		Bubble sort the ArrayList of words. For every iteration, an item in the list is put in the correct position.
		while(flag){
			flag = false;
			for(int i = 0; i < words.size(); i++){
				if(i != words.size() - 1){
					if(words.get(i).hasMoreOccurrencesThan(words.get(i + 1)))
						continue;
					Node temp = null;
					temp = words.get(i);
					words.set(i, words.get(i+1));
					words.set(i+1, temp);
					flag = true;
				}
			}
		}
	}
	
	public void addNode(Node node){
//		If the word list is empty, add the node to it.
		if(words.size() == 0){
			words.add(node);
		}
		
//		Otherwise, check if the list already holds a node with that word.
		else{
			for(int j = 0; j < words.size(); j++){
				
//				If it does, increment it.
				if(words.get(j).Equals(node)){
					words.get(j).increment();
					break;
				}
				
//				Otherwise add it.
				else if(j == words.size()-1){	
					words.add(node);
					break;
				}
			}
		}
	}
}