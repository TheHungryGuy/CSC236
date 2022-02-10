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
	ArrayList<Dictionary> dict = new ArrayList<Dictionary>();  //ArrayList to hold Words added in 
	
	//default constructor
	public Dictionary() {
	
		//an empty object
	}
	
	public Dictionary(String Word)
	   {
	       this.word=Word;
	    
		}

	
	@Override
	public void addWord(String word) {
		
		new Dictionary(this.word);
		
	}

	@Override
	public boolean isWord(String word) {//to return true or false if the species match
		return this.word.equals(word);
	}

	@Override
	public int getSize() {
		
		return dict.size();
	}

	
	public void writeDict(ArrayList<Dictionary> dictFileName) {
		  BufferedReader reader;
	       String word;
	       
	       try
	       {
	           reader = new BufferedReader(new FileReader(dictFileName));
	           String line = reader.readLine();
	           while (line != null)
	           {
	               word=line;
	               // read next line
	      
	              dict.add(new Dictionary(word));
	               line = reader.readLine();
	           }
	           reader.close();
	       }
	       catch (IOException e)
	       {
	           System.out.println("File not found");
	       }
		
	}

	public String toString() { //to print out arraylist
		
	       String str="";
	       str+="Word: "+word;

	       return str;
	}
	
}
