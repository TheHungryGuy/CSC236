package linkedCollectionExercise;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

import linkedCollectionExercise.LinkedCollection.LinkedCollectionIterator;

public class CollectExClient<T> implements Iterable  {
	public static void main(String[] args) throws IOException {

		LinkedCollection<Person> collect = new LinkedCollection<Person>();
		System.out.println("Input file name containing persons:");
		//person.dat
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		File file = new File(input.nextLine());
		Scanner people = new Scanner(file);
		build(collect,people);

		String exitLoop ="n";
		String addPerson ="n" ;
		while(exitLoop.equalsIgnoreCase("n")) {
			System.out.println("Type in the First Name");
			String fName = input.nextLine();
			System.out.println("Type in the Last Name");
			String lName = input.nextLine();
			Person check = new Person(fName,lName,0,"zero");
			collect.find(check);
			if (collect.found) {
				System.out.println(collect.location.getInfo());

			} 

			if(!collect.found) {
				System.out.println("Person not found in collection!");
				System.out.println("Would you like to add person in? type y or n");
				addPerson = input.nextLine();
			}
			if(addPerson.equalsIgnoreCase("y")) {
				//method to add person
				System.out.println("Enter the Age of "+fName+" "+lName);
				int age = input.nextInt();
				input.nextLine();
				System.out.println("Enter the Cell Number");
				String cell = input.nextLine();
				addPeep(collect,fName,lName,age,cell);
			}
			System.out.println("Would you like to exit the loop? type y or n");
			exitLoop = input.nextLine();
		}

		Iterator<Person> iter = collect.iterator;
		for (Person person: collect) {
			System.out.println(collect);
		}
		
		

	}

	// read each person from the given Scanner, create a Person object, and add
	// the Person to mypeeps
	public static void build(CollectionInterface<Person> mypeeps, Scanner peopleFile) {
		String fname;
		String lname;
		int age;
		String cell;
		@SuppressWarnings("unused")
		String dummy;
		Person onepeep;

		// this code assumes that each field of the Person is on a separate line
		// in the input file
		while (peopleFile.hasNext()) {
			fname = peopleFile.nextLine();
			lname = peopleFile.nextLine();
			age = peopleFile.nextInt();
			// read the newline which is left after the call to nextInt
			dummy = peopleFile.nextLine();
			cell = peopleFile.nextLine();
			onepeep = new Person(fname, lname, age, cell);
			mypeeps.add(onepeep);
		}
	}
	public static void addPeep(CollectionInterface<Person> mypeeps,String first, String last, int age, String cell) {
		Person onepeep = new Person(first,last,age,cell);
		mypeeps.add(onepeep);
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new LinkedCollectionIterator();
	}
	
	
	
	

	

	
	
	

}
