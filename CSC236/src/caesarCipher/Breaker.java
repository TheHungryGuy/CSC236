//Antonio Arce CSC236 Data Structures in Java Lab 1
package caesarCipher;

public class Breaker {
	
	private final int maxShiftKey = 4;
	private final int maxModKey = maxShiftKey -1;
	private int shiftKey = 0;
	private int modKey = 0;
	private int modKeyCount = 0;
	
	
	
	public void Break(String encryptedText) {
		
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
		        String decryptedText = String.valueOf(encryptArr); //Store encryptedText
		
		        System.out.println(decryptedText  + " is the decrypted code of " + encryptedText +
		        		" with a shift key of " + shiftKey + " and mod key of " + modKey); //print out to test
			
		        
		        modKey++;
			}
		
			shiftKey++;
			modKey=0;
		}
		
		
	}
	
	

}
//The Breaker class will contain the method to break the Caesar cipher.
//The parms are the ciphertext String and the maximum shift key to try.
//The method will return the plaintext String.
//If none of the shift key/mod key pairs result in a message where all words are English, the method should return null.
