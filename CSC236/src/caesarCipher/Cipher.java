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
	
		modKeyCount =0;
		char[]encryptArr = plainText.toCharArray();		//convert plainText into char array
		
		for(int i=0;i<plainText.length();i++) {			//run for loop till last letter of plainText
			
			if(Character.isLetter(plainText.charAt(i))) { //checks if character is a letter if not skips
				
				if(Character.isUpperCase(plainText.charAt(i))) { //checks if its uppercase
					encryptArr[i] = (char) ((((int)encryptArr[i]+ shiftKey +modKeyCount - 65) % 26 + 65)); //shift letters in using shiftKey

				}else {	//goes to lowercase other wise
					encryptArr[i] = (char) ((((int)encryptArr[i]+ shiftKey+ modKeyCount - 97) % 26 + 97)); //shift letters in using shiftKey

				}
				modKeyCount++; 		//Add 1 to the count so on next loop adds an extra
				if(modKeyCount > modKey) { 	//when the modKeyCount goes over modKey
					modKeyCount = 0;  //modKeyCount gets reset back to zero
							
					}
				} //String test = String.valueOf(encryptArr);
				//System.out.println(test);
			
			
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
			
			// String test = String.valueOf(encryptArr);
				//System.out.println(test);
			
			
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

	//abcdefghijklmnopqrstuvwxyz + ABCDEFGHIJKLMNOPQRSTUVWXYZ

}

//The Cipher class will contain the encrypt and decrypt methods.
//The keys should be stored as fields of the class.
//Both encrypt and decrypt have one parm: the String to be encrypted/decrypted.
//The String may include upper and lower case (which should be preserved) and special characters (which should not be modified).
// Both functions return the resulting String.