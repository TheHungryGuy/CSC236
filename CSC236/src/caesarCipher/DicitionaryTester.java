package caesarCipher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;





//instance variable for dictionary class

public class DicitionaryTester {

	

	public static void main(String[] args) {
		
		ArrayList<Dictionary> dict = new ArrayList<Dictionary>();  //ArrayList to hold Words added in 
		
		
		
		
		   @SuppressWarnings("resource")
		   Scanner keyboard = new Scanner(System.in);//Create scanner item
		   System.out.println("Enter dictionary file name: \t"); //prompt for the name of the file with plaintext Strings
		   String fileName = keyboard.nextLine(); //entry becomes the filename
		   
		   readData(dict,fileName); //Use private method readData to read in data from file and add into to ArrayList 
		   System.out.println("This is the begining!");
		   System.out.println();
		   
		   printData(dict); //Print entire dictionary to test that it works
		   
		   System.out.println();
		   System.out.println("This is the end!"); 
		   System.out.println("There are " + dict.size() + " words in the dictionary!\n");
		   
		
			System.out.println("Insert a String: "); //Ask for string
			
			String userInput = keyboard.nextLine(); //users input saved in userInput String

			while (!userInput.equals("end")) {
				//check if word is in dictionary
				checkWords(dict,userInput);
				userInput = keyboard.nextLine(); //overwrites userInput string with word inserted
				
			}
			
	}
	
	
	private static void readData(ArrayList<Dictionary> Dict,String file)
	   {
	       BufferedReader reader;
	       String word;
	       
	       try
	       {
	           reader = new BufferedReader(new FileReader(file));
	           String line = reader.readLine();
	           while (line != null)
	           {
	               word=line;
	               // read next line
	      
	              Dict.add(new Dictionary(word));
	               line = reader.readLine();
	           }
	           reader.close();
	       }
	       catch (IOException e)
	       {
	           System.out.println("File not found");
	       }
	   }
	
	private static void printData(ArrayList<Dictionary> Dict) {
		 for(Dictionary d:Dict)
         {
             System.out.println(d);
         }
	}

	private static void checkWords(ArrayList<Dictionary> dict, String word){
		boolean wordFound =  false; //boolean to hold false value until a word is found
		
		for(int i=0;i<dict.size();i++){	//run for loop thru dict
			if(dict.get(i).isWord(word)) { //check if userInput matches any word in dict
				System.out.println("Word Found!\n" + dict.get(i)); //Print out found word
				wordFound = true; //change value to true since word has been found
	}
		}
		//if word goes thru full loop without finding a match 
		//system will print out no match found and prompt for a new string
		if(wordFound == false) { 
				System.out.println("Word not found!\n" +"Insert a new string: ");
			}
		}
		
		
		
	
}
