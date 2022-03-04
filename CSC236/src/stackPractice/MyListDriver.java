package stackPractice;

import java.util.Scanner;

public class MyListDriver {

	public static void main(String[] args) {
		MyList mylist = new MyList();
		
		mylist.createList("blue");
		//System.out.println(mylist.head.getInfo());
		mylist.addAtFront("green");
		//System.out.println(mylist.head.getInfo());
		mylist.addAtFront("red");
		//System.out.println(mylist.head.getInfo());
		
		System.out.println(mylist.toString());
		
		System.out.println("Insert a word:\t");
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.nextLine();
		mylist.addAtFront(input);
		System.out.println("Insert a word:\t");
		input = keyboard.nextLine();
		mylist.addAtFront(input);
		
		System.out.println(mylist.toString());
		System.out.println("Insert a word:\t");
		input =  keyboard.nextLine();
		mylist.contains(input);
		System.out.println(mylist.toString());

	}

}
