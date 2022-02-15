//Antonio Arce CSC236 Data Structures in Java Lab 1
package caesarCipher;

import java.util.ArrayList;

public class Breaker {
	
	private final int maxShiftKey = 10; //max Shift key amount which will not be changed
	private final int maxModKey = maxShiftKey -1; //max mod key will always be 1 under the shift key
	private int shiftKey = 0;
	private int modKey = 0;
	private int modKeyCount = 0;
	private boolean broken = false;
	private boolean tripped = false;
	
	public String Break(String encryptedText) {		//method to brute force caesar cipher and find keys 
		String decryptedText = null;
		Dictionary dictionary = new Dictionary();  //calls dictionary class
		dictionary.writeDict("dictionary.txt");  //writes dictionary from file	
		
		for(int k =0; k <= maxShiftKey;k++) {
			for(int j =0; j <= maxModKey; j++ ) {
				modKeyCount =0;
				char[]encryptArr = encryptedText.toCharArray();		//convert plainText into char array
				for(int i=0;i<encryptedText.length();i++) {			//run for loop till last letter of plainText
					if(Character.isLetter(encryptedText.charAt(i))) { //checks if character is a letter if not skips
						if(Character.isUpperCase(encryptedText.charAt(i))) { //checks if its uppercase
							int pos= ((int)encryptArr[i]-65); //0-26
							int shift = (shiftKey+modKeyCount); // total shift for cycle
							if((pos-shift<0)) {	//checks if goes under uppercase ascii code
								encryptArr[i]= (char) ((int)encryptArr[i]+26); //adds 26 to "loop" back to top
							}
							encryptArr[i] = (char) ((int)encryptArr[i]- shiftKey -modKeyCount); //shift letters in using shiftKey+modKey
						}
						if(Character.isLowerCase(encryptedText.charAt(i))) {	//goes to lowercase other wise							
							int pos= ((int)encryptArr[i]-97); //0-26
							int shift = (shiftKey+modKeyCount);
							if((pos-shift<0)) { //checks if goes under lowercase ascii code
								encryptArr[i]= (char) ((int)encryptArr[i]+26); //adds 26 to "loop" back to top
							}
							encryptArr[i] = (char) ((int)encryptArr[i]- shiftKey -modKeyCount ); //shift letters in using shiftKey+modKey
						}
						modKeyCount++; 		//Add 1 to the count so on next loop adds an extra
						if(modKeyCount > modKey) { 	//when the modKeyCount goes over modKey
							modKeyCount = 0;  //modKeyCount gets reset back to zero								
							}
						}
				}
		        decryptedText = String.valueOf(encryptArr); //Store encryptedText		        
		        String[] words = decryptedText.split("\\s+"); //to split a string into array to compare to
		        if(checkWords(dictionary.dict,words[0])) {	//checks if first word is in the dict if not then skips
		        	tripped = false; //boolean in case only the last word is true 
		        	for(int w =1;w<words.length;w++) { //for loop to check thru each word that was in the string
		        		if(checkWords(dictionary.dict,words[w])) { //if checkWords returns as true for current word
		        			broken = true;							//then sets broken as true
		        		}else {						// if in any part it returns false
		        			broken = false;			// broken is set back to false
		        		 	tripped = true;			// tripped is set as true just in case last word sets broken to true 
		        		}
		        	}
		        	if(broken && !flagTripped()) {//as long as broken is true and tripped is false
		        		System.out.println(shiftKey +" "+ modKey); //prints current shift key and mod key
		        		 System.out.println(decryptedText  + " is the decrypted code of " + encryptedText +
		 		        		" with a shift key of " + shiftKey + " and mod key of " + modKey); 
		        		 break; //exits out of loops
		        	}
		        }
	        	if (broken && !flagTripped()) { //as long as broken is true and tripped is false
	        		break; //exits out of loop
	        	}
		        modKey++;
			}
        	if (broken && !flagTripped()) { //as long as broken is true and tripped is false
        		break; //exits out of loop
        	}
 			shiftKey++;
			modKey=0;
		}
		return decryptedText;	
	}
	
	private static boolean checkWords(ArrayList<Dictionary> dict, String word){ //method to check words against dictionary
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
				System.out.println("Word not found!\n" );
				
			}
		return wordFound;
		}

	public boolean flagTripped() { //check for flag tripping
		return tripped;
	}
		
	
	
	
	

}
//The Breaker class will contain the method to break the Caesar cipher.
//The parms are the ciphertext String and the maximum shift key to try.
//The method will return the plaintext String.
//If none of the shift key/mod key pairs result in a message where all words are English, the method should return null.
