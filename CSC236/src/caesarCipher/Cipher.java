package caesarCipher;

import java.util.ArrayList;
//Antonio Arce CSC236 Data Structures in Java Lab 1
@SuppressWarnings("unused")
public class Cipher {
	
	//attributes
	
	private int shiftKey = 0;
	private int modKey = 0;
	private int modKeyCount = 0;
	
	
	public String encrypt(String plainText) {
		//plainText is the String to be encrypted
	
		modKey =0;
		char[]encryptArr = plainText.toCharArray();		//convert plainText into char array
		for(int i=0;i<plainText.length();i++) {			//run for loop till last letter of plainText
			
			if(Character.isLetter(plainText.charAt(i))) { //checks if character is a letter if not skips
				encryptArr[i] = (char) (encryptArr[i]+ shiftKey); //shift letters in using shiftKey
				encryptArr[i] = (char) (encryptArr[i]+ modKeyCount); //shift letters in using modKey
				modKeyCount++; 		//Add 1 to the count so on next loop adds an extra
				if(modKeyCount > modKey) { 	//when the modKeyCount goes over modKey
					modKeyCount = 0;  //modKeyCount gets reset back to zero
							
					}
				}
		}
        String encryptedText = String.valueOf(encryptArr); //Store encryptedText

        System.out.println(encryptedText + " is the ceasar cipher code of " + plainText +
        		" with a shift key of " + shiftKey + " and mod key of " + modKey); //print out to test
        
        return encryptedText; //returns the encrypted text to call
		
	}
	
	
	//km rrq! = Hi Mom! (Shift key-3, Mod key- 2)
	
	public String decrypt(String encryptedText) {
		
		modKeyCount =0;
		char[]encryptArr = encryptedText.toCharArray();		//convert plainText into char array
		for(int i=0;i<encryptedText.length();i++) {			//run for loop till last letter of plainText
			
			if(Character.isLetter(encryptedText.charAt(i))) { //checks if character is a letter if not skips
				encryptArr[i] = (char) (encryptArr[i]- shiftKey); //shift letters in using shiftKey
				encryptArr[i] = (char) (encryptArr[i]- modKeyCount); //shift letters in using modKey
				modKeyCount++; 		//Add 1 to the count so on next loop adds an extra
				if(modKeyCount > modKey) { 	//when the modKeyCount goes over modKey
					modKeyCount = 0;  //modKeyCount gets reset back to zero
							
					}
				}
		}
        String decryptedText = String.valueOf(encryptArr); //Store encryptedText

        System.out.println(decryptedText  + " is the decrypted code of " + encryptedText +
        		" with a shift key of " + shiftKey + " and mod key of " + modKey); //print out to test
		
		
		
		
		
		return decryptedText; //returns the decrypted text to call
	}


	public void changeShiftKey(int shiftKey) {
		this.shiftKey = shiftKey;
	}


	public void changeModKey(int modKey) {
		this.modKey = modKey;
	}

	

}

//The Cipher class will contain the encrypt and decrypt methods.
//The keys should be stored as fields of the class.
//Both encrypt and decrypt have one parm: the String to be encrypted/decrypted.
//The String may include upper and lower case (which should be preserved) and special characters (which should not be modified).
// Both functions return the resulting String.