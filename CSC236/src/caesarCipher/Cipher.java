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
		System.out.println("ahhhhh");
		char[]encryptArr = plainText.toCharArray();		//convert plainText into char array
		for(int i=0;i<plainText.length();i++) {			//run for loop till last letter of plainText
			
			if(Character.isLetter(plainText.charAt(i))) { //checks if character is a letter if not skips
				encryptArr[i] = (char) (encryptArr[i]+ shiftKey); //shift letters up using shiftKey
				if(modKeyCount <= modKey) {					//if statement to add in modKey
					encryptArr[i] = (char) (encryptArr[i]+ modKeyCount); //shift letters up using modKey
					encryptArr[i] = (char) (encryptArr[i]+ modKeyCount); //shift letters up using modKey
					modKeyCount++; 		//Add 1 to the count so on next loop adds an extra
					
					if(modKeyCount > modKey) { 	//when the modKeyCount goes over modKey
						modKeyCount = 0;  //modKeyCount gets reset back to zero
						
							}
					}
				}
				
			}
        String encryptedText = String.valueOf(encryptArr); //Store encryptedText

        System.out.println(encryptedText); //print out to test
        
        return encryptedText;
		
	}
	
	
	//km rrq! = Hi Mom! (Shift key-3, Mod key- 2)
	
	public String decrypt(String encryptedText) {
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
		return decryptText;
	}

	public int getModKey() {
		return modKey;
	}

	public void setModKey(int modKey) {
		this.modKey = modKey;
	}

}

//The Cipher class will contain the encrypt and decrypt methods.
//The keys should be stored as fields of the class.
//Both encrypt and decrypt have one parm: the String to be encrypted/decrypted.
//The String may include upper and lower case (which should be preserved) and special characters (which should not be modified).
// Both functions return the resulting String.