package caesarCipher;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class Dictionary implements DictionaryInterface  {
	/* The Dictionary class will have a field to hold the words; the type of this field will be an ArrayList of Strings. 
	 * The ArrayList is part of the Java API. 
	 * To use it, you must import java.util.ArrayList.
	 */
	
	//attributes
	private String word;
	private int size;
	
	//default constructor
	public Dictionary() {
		//don't do anything here
		//bec, it's just an empty object...
	}
	
	public Dictionary(String Word)
	   {
	       this.word=Word;
	    
		}

	
	@Override
	public void addWord(String word) {
	
		
	}

	@Override
	public boolean isWord(String word) {//to return true or false if the species match
		return this.word.equals(word);
	}

	@Override
	public int getSize() {
		
		return this.size;
	}

	
	public void writeDict(String dictFileName) {
		// TODO Auto-generated method stub
		
	}

	public String toString() { //to print out arraylist
		
	       String str="";
	       str+="Word: "+word;

	       return str;
	}
	
}
