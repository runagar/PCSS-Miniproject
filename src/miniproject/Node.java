package miniproject;

// Node class. Use to store words.

public class Node {

	private String word;
	private int count;
	
//	Constructor
	public Node(String word){
		this.word = word;
		this.count = 1;
	}
	
//	Call to increase the count of a word
	public void increment(){
		this.count++;
	}
	
	public String getWord(){
		return word;
	}
	
//	Equals method. Use to check if a node has already been constructed on a word.
	public boolean Equals(Node node){
		if(this.word.equals(node.getWord()))
			return true;
		return false;
	}
	
//	toString. Use when printing the arrayList of nodes.
	public String toString(){
		String node = this.word + " x " + this.count;
		return node;
	}
	
//	Use to compare words when sorting for occurrences
	public boolean hasMoreOccurrencesThan(Node word){
		if(word.count > this.count)
			return false;
		return true;
	}
}
