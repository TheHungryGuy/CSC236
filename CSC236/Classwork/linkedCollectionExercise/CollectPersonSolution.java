package linkedCollectionExercise;

// create a Collection of Persons
// fill the Collection from a file
// search for Persons in the Collection and add them if not found

import java.io.*;
import java.util.Scanner;
import java.util.Iterator;

public class CollectPersonSolution {
	public static void main(String[] args) throws IOException {
		LinkedCollection<PersonSolution> myPeople =	new LinkedCollection<PersonSolution>();
		String fname;
		String lname;
		PersonSolution onepeep;
		int again;
		String dummy;

		// get the name of the input file and open it
		Scanner keybd = new Scanner(System.in);
		System.out.print("Enter the name of the Person file: ");
		String filename = keybd.nextLine();
		File infile = new File(filename);
		Scanner personFile = new Scanner(infile);

		// read file and store all the people in the collection
		build(myPeople, personFile);

		// get people and add them to the collection
		do {
			System.out.print("\nEnter first name: ");
			fname = keybd.nextLine();
			System.out.print("Enter last name: ");
			lname = keybd.nextLine();
			onepeep = new PersonSolution(fname, lname, 0, null);
			System.out.println(onepeep);
			onepeep = myPeople.get(onepeep);
			if (onepeep != null)
				System.out.println("\nThe person is:\n" + onepeep);
			else {
				System.out.println("\nPerson not found\n");
				System.out.print("\nAdd person? (1: yes, 0: no) ");
				again = keybd.nextInt();
				if (again == 1)
					addPerson(fname, lname, myPeople, keybd);
			}
			System.out.print("\n\nFind another person? (1: yes, 0: no) ");
			again = keybd.nextInt();
			dummy = keybd.nextLine();
		} while (again == 1);

	}

	// read Persons from a file and store them in the Collection
	public static void build(CollectionInterface<PersonSolution> mypeeps, Scanner peopleFile) {
		String fname;
		String lname;
		int age;
		String cell;
		String dummy;
		PersonSolution onepeep;
		while (peopleFile.hasNext()) {
			fname = peopleFile.nextLine();
			lname = peopleFile.nextLine();
			age = peopleFile.nextInt();
			dummy = peopleFile.nextLine();
			cell = peopleFile.nextLine();
			onepeep = new PersonSolution(fname, lname, age, cell);
			System.out.println(onepeep);
			mypeeps.add(onepeep);
		}
	}

	// add new person to the collection
	// fname and lname were read in by the caller
	public static void addPerson(String fname, String lname,
							CollectionInterface<PersonSolution> myPeeps, Scanner keybd) {
		int age;
		String cell;
		String dummy;
		PersonSolution newpeep;
		System.out.print("age: ");
		age = keybd.nextInt();
		dummy = keybd.nextLine();
		System.out.print("cell: ");
		cell = keybd.nextLine();
		newpeep = new PersonSolution(fname, lname, age, cell);
		myPeeps.add(newpeep);
	}
}
