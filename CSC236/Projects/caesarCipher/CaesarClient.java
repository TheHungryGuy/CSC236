//Antonio Arce CSC236 Data Structures in Java Lab 1

package caesarCipher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CaesarClient {

	public static void main(String[] args) {
		
		
		Breaker breaker = new Breaker();
		Cipher ceasar = new Cipher(); //creates an obj of cipher class
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in); //create a class of obj scanner to for keyboard inputs

		//1. prompt for the name of the file with plaintext Strings and the name of the file to hold the ciphertext
		System.out.println("Enter name of plaintext strings file to encrypt:\t");
		String plainFile = keyboard.nextLine();
		System.out.println("Enter the name of file to hold the cipher");
		String cipherFile = keyboard.nextLine();
		//2. prompt for keys
		System.out.println("Enter the shift key:\t"); //prompt for shift key
		ceasar.changeShiftKey( keyboard.nextInt()); 
		System.out.println("Enter the mod key:\t");//prompt for mod key
		ceasar.changeModKey( keyboard.nextInt()); 
		//keyboard.nextLine();


		//3. read each line of the file, encrypt it, and write the ciphertext to the output file
		ArrayList<String> plainArray = new ArrayList<>(); //ArrayList to hold strings from plainFile
		ArrayList<String>encryptArray = new ArrayList<>();//Arr to hold encrypted strings
		readFile(plainFile,plainArray); //run method to read in and write to array
		for(int i =0; i<plainArray.size();i++) { //run thru each line of the array and encrypt it
			encryptArray.add(i, ceasar.encrypt(plainArray.get(i))); 
		}
		
		writeFile(cipherFile,encryptArray);
		//4. prompt for the name of the file with ciphertext Strings and the name of the file to hold the plaintext
		System.out.println();
		System.out.println("Now encrypting...");
		System.out.println(".................");
		System.out.println();
		
		System.out.println("Enter the name of cipher text file:\t"); //prompt for name
		keyboard.nextLine();
		cipherFile = keyboard.nextLine();
		System.out.println("Enter name of file to hold the decryption:\t");//prompt for name 
	    plainFile = keyboard.nextLine();
		//5. prompt for the keys
		System.out.println("Enter the shift key:\t"); //prompt for shift key
		ceasar.changeShiftKey( keyboard.nextInt()); 
		System.out.println("Enter the mod key:\t");//prompt for mod key
		ceasar.changeModKey( keyboard.nextInt()); 
		//6.read each line of the file, decrypt it, and write the plaintext to the output file
		System.out.println();
		System.out.println("Now decrypting...");
		System.out.println("..................");
		System.out.println();
		readFile(cipherFile,encryptArray); //reads cipher file into encrpytarray
		plainArray.clear();//clears array for reuse
		for(int i =0; i<encryptArray.size();i++) { //run thru each line of the array and encrypt it
			plainArray.add(i, ceasar.decrypt(encryptArray.get(i))); //adds to array whenever decrypt returns
		}
		writeFile(plainFile,plainArray); //write from plainarray to file
		
		
		//7. prompt for the name of the file with ciphertext to be broken and the name of the file to hold the plaintext
		System.out.println();
		System.out.println("Enter the name of cipher text file:\t");
		keyboard.nextLine();
		cipherFile = keyboard.nextLine();
		readFile(cipherFile,encryptArray);// reads fomr cipher file into encryptarray
		System.out.println("Enter name of file to hold the decryption:\t");
		plainFile = keyboard.nextLine();
		System.out.println("Brute force decrypting...");
		plainArray.clear();  //array cleared
		
		//run for loop for breaker class
		for(int i =0; i<encryptArray.size();i++) {
			plainArray.add(i, breaker.Break(encryptArray.get(i)));  //when break returns , string added to array
		}
		if(!breaker.flagTripped()) { //writes to file if succesfully brute forced
			writeFile(plainFile,plainArray);
		}else { //else prints out to screen that keys not found
			System.out.println("Code not broken! Keys not found! ");
		}
		
		

		
		//ceasar.decrypt("km rrq!");
	//	System.out.println();
		//ceasar.decrypt("km psp!");
		//System.out.println(ceasar.decrypt("km psp!"));
	}
	
	private static void readFile(String fileName, ArrayList<String> fileArray) { //reads in a file and writes it to an array
		  BufferedReader reader;
	       String words;
	       fileArray.clear();
	       try
	       {
	           reader = new BufferedReader(new FileReader(fileName));
	           String line = reader.readLine();
	           while (line != null)
	           {
	               words=line;
	               // read next line
	      
	              fileArray.add(new String(words));
	               line = reader.readLine();
	           }
	           reader.close();
	       }
	       catch (IOException e)
	       {
	           System.out.println("File not found");
	       }
		
	
		
	}
	private static void writeFile (String filename, ArrayList<String> fileArray) { //writes an array to a file
		FileWriter writer;			//Writes ArrayList to CipherFile
		try {
			writer = new FileWriter(filename);
		for(String str: fileArray) {
		  writer.write(str + System.lineSeparator());
		}
		writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
