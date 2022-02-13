//Antonio Arce CSC236 Data Structures in Java Lab 1
package caesarCipher;

public class Breaker {
	
	private final int maxShiftKey = 4;
	private int shiftKey = 0;
	private int modKey = 0;
	int modKeyCount = 0;
	
	
	public void Break(String encryptedText) {
		//encryptedText is the String to be decrypted
		
		String decryptText = null;
		char[]encryptArr = encryptedText.toCharArray();		//convert plainText into char array
		shiftKey = 0;										//Resets shiftKey to 0
		
		for(int j=1; j<=maxShiftKey; j++) {						//run for loop until go past the max
			shiftKey++;											//increase the shiftKey
			modKey = shiftKey;									//Sets the modKey to be just 1 under the shift key
			int modMax = modKey -1; 							//Saves the max that modKey can be on this loop
			for(int k=0; k<= modMax;k++) {						//for loop to run thru each modKey
				modKey--;											//Reduces modKey by 1
				modKeyCount = 0;								//Set the count to the modKey
				encryptArr = encryptedText.toCharArray();			//resets Array 
				
				for(int i=0; i<encryptedText.length();i++) {		//run for loop till last letter of plainText
					if(Character.isLetter(encryptedText.charAt(i))) {			//checks if character is a letter if not skips
						encryptArr[i] = (char) (encryptArr[i]- shiftKey);		 //shift letters in using shiftKey
						encryptArr[i] = (char) (encryptArr[i]- modKeyCount);
						if(modKeyCount <= modKey) {									//if statement to subtract in modKey
									
							modKeyCount++; 												//Add 1 to the count so on next loop adds an extra
							//System.out.println(modKeyCount);
							if(modKeyCount >= modMax ) {
								modKeyCount = 0;									// Resets modKeyCount back to current max
								//System.out.println( "Reset mod keycount\t" + modKeyCount);
							}
						}	
						//String decryptText = String.valueOf(encryptArr);		//Store decrypted text in string
						//System.out.println(decryptText  + "\tShift Key-" + shiftKey +  "\tMod Key-"+ modKey); //Test print
					}
					//String decryptText = String.valueOf(encryptArr);		//Store decrypted text in string
					//System.out.println(decryptText  + "\tShift Key-" + shiftKey +  "\tMod Key-"+ modKey); //Test print
				}
				 decryptText = String.valueOf(encryptArr);		//Store decrypted text in string
				System.out.println(decryptText  + "\tShift Key-" + shiftKey +  "\tMod Key-"+ modKey); //Test print
				
			}
		}
	}	

}
//The Breaker class will contain the method to break the Caesar cipher.
//The parms are the ciphertext String and the maximum shift key to try.
//The method will return the plaintext String.
//If none of the shift key/mod key pairs result in a message where all words are English, the method should return null.
