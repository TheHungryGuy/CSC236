package queueExercise;

import java.util.Scanner;

public class PersonClient {

	public static void main(String[] args) {
		Person person = new Person();
		//import arrayunboundedque class
		ArrayUnboundedQueue<Person> queue = new ArrayUnboundedQueue<>();
		// write for loop to prompt for name,age, & cell number

		//import scanner to read in inputs
		Scanner keyboard = new Scanner(System.in);
		//String to hold inputs
		String input ="";
		while(!input.equals("done")) {
			System.out.println("Insert a Name: ");
			String name = keyboard.nextLine();
			System.out.println("Insert the age: ");
			int age = keyboard.nextInt();
			keyboard.nextLine();//clear out keyboard
			System.out.println("Insert the Cell Number: ");
			String cellNum = keyboard.nextLine();
			queue.enqueue(new Person(name,age,cellNum));
			System.out.println("enter done if you are finshed or any other key to continue");
			input = keyboard.nextLine();
		}


	}

}
