//Antonio Arce CSC236 Data Structures in Java Lab 1

package caesarCipher;

public class CaesarClient {

	public static void main(String[] args) {
		
		
		Cipher ceasar = new Cipher();
		
		
		//ceasar.decrypt("km rrq!");
		System.out.println();
		//ceasar.decrypt("km psp!");
		System.out.println(ceasar.decrypt("km psp!"));
	}

}
