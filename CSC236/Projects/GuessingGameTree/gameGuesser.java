package GuessingGameTree;
//Antonio Arce CSC236 Data Structures in Java Lab 4

import java.util.Scanner;

public class gameGuesser {


	Scanner kb = new Scanner(System.in);
	
	public void guesser(BinTree<String> Tree) {
		//checks if it is at the bottom of the tree
		if(Tree.left == null && Tree.right == null) {
			System.out.println("Are you a " + Tree.getInfo() + "?");
		}
		else {
		System.out.println(Tree.getInfo()); 
		}
		String input = kb.nextLine();
		//if the answer is yes it will check the left tree
		if(input.equalsIgnoreCase("y")) {
			//if the left tree is null then the answer has been found
			if(Tree.left == null)
				System.out.println("Got It!!!!");
			//else it ask the next question
			else 
				guesser(Tree.left);
		}
		//if the answer is no it will check the right tree
		else {
			//if the right tree is null then the answer cannot be found
			if(Tree.right == null) {
				System.out.println("I Give Up! What Are You?");
				input = kb.nextLine(); //new animal
				System.out.println("Please enter a question that is true for a "
						+ input
						+ " and false for a "
						+ Tree.getInfo()
						+ " .");
				String question = kb.nextLine();
				//call method to change the order
				addAnimal(Tree,input,question);
			}
				//else it ask the next question
			else 
				guesser(Tree.right);
		}
	}
	
	public void addAnimal (BinTree<String> Tree,String animal,String question) {
		
		BinTree<String> newAnimal = new BinTree<>(animal);
		String temp = Tree.getInfo();
		Tree.setInfo(question);
		Tree.attachLeft(newAnimal);
		BinTree<String> oldAnimal = new BinTree<>(temp);
		Tree.attachRight(oldAnimal);
	}
}
