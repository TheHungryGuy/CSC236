package GuessingGameTree;
//Antonio Arce CSC236 Data Structures in Java Lab 4

import java.util.Scanner;

public class clientGame {

	public static void main(String[] args) {
		//create initial bintree class
		String iniLeft = "hamster";
		String iniRight="snake";	
		BinTree<String> gameTreeL = new BinTree<>(iniLeft);
		BinTree<String> gameTreeR = new BinTree<>(iniRight);
		BinTree<String> gameTree = new BinTree<String>("Are you a mammal?",gameTreeL,gameTreeR);
		gameGuesser game = new gameGuesser();
		boolean play = true;
		
		System.out.println("Think of an animal.\r\n"
				+ "I will ask you a series of yes/no questions\r\n"
				+ " and I will try to guess the animal.If I can't guess the animal, you can help me learn\r\n"
				+ "how to guess that animal by giving me a new question.\r\n"
				+ "");
		
		while(play) {
			@SuppressWarnings("resource")
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Think of an animal. When you're ready, press return.");
			String input = keyboard.nextLine();
			//recursive loop thats plays the game
			game.guesser(gameTree);
			//returns back when game is done
			System.out.println("Shall we play again? [Please type y or n]");
			input = keyboard.nextLine();
			if(input.equalsIgnoreCase("n"))
				play = false;
		}//while loop end
		System.out.println("GoodBye!");
	}

}
