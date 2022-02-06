package caesarCipher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;




public class DicitionaryTester {

	public static void main(String[] args) {
		
		ArrayList<Dictionary> dict = new ArrayList<Dictionary>();  //ArrayList to holdw Words added in 
		   readData(dict); //Use private method readData to read in data from file and add into to ArrayList 
		   System.out.println("This is the begining!");
		   System.out.println();
		//   printData(dict);
		//   System.out.println();
		//   System.out.println("This is the end!");
		   System.out.println(dict.size());
		   System.out.println(dict.get(100));
		   
	}
	
	
	private static void readData(ArrayList<Dictionary> Dict)
	   {
	       BufferedReader reader;
	       String word;
	       
	       try
	       {
	           reader = new BufferedReader(new FileReader("dictionary.txt"));
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

}
