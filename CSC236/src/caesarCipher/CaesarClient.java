//Antonio Arce CSC236 Data Structures in Java Lab 1

package caesarCipher;

import java.util.Scanner;

public class CaesarClient {

	public static void main(String[] args) {
		
		
		String plainText;
		String encryptedText;
		String decryptedText;
		
		Breaker breaker = new Breaker();
		Cipher ceasar = new Cipher(); //creates an obj of cipher class
		Scanner keyboard = new Scanner(System.in); //create a class of obj scanner to for keyboard inputs
		
		
		
		 
		System.out.println("Enter a String to encrypt:\t"); //prompt for string to encrypt
		plainText = keyboard.nextLine(); // save input as plaintext
		System.out.println("Enter the shift key:\t"); //prompt for shift key
		ceasar.changeShiftKey( keyboard.nextInt()); 
		System.out.println("Enter the mod key:\t");//prompt for mod key
		ceasar.changeModKey( keyboard.nextInt()); 
		encryptedText = ceasar.encrypt(plainText) ; //saves the encrypted text in string
	
		
		System.out.println();
		System.out.println("Now decrypting...");
		System.out.println("Enter the shift key:\t"); //prompt for shift key
		ceasar.changeShiftKey( keyboard.nextInt()); 
		System.out.println("Enter the mod key:\t");//prompt for mod key
		ceasar.changeModKey( keyboard.nextInt()); 
		decryptedText = ceasar.decrypt(encryptedText);
		
		System.out.println();
		System.out.println(decryptedText); //test
		System.out.println();
		
		//encryptedText = "km rrq";
		
		//prompt for the name of the file with ciphertext to be broken and the name of the file to hold the plaintext
		System.out.println("Brute force decrypting...");
		breaker.Break(encryptedText);
		
		
		
		
		
		
		
		
		
		
		
		//ceasar.decrypt("km rrq!");
	//	System.out.println();
		//ceasar.decrypt("km psp!");
		//System.out.println(ceasar.decrypt("km psp!"));
	}

}
