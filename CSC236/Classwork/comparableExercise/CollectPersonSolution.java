package comparableExercise;

// create a Collection of Persons
// fill the Collection from a file
// search for Persons in the Collection and add them if not found

import java.io.*;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Iterator;

public class CollectPersonSolution {
	public static void main(String[] args) throws IOException {
		SortedABList<PersonSolution> myPeople =	new SortedABList<PersonSolution>(PersonSolution.ageComparator());
		String fname;
		String lname;
		PersonSolution onepeep;
		int again =0;
		String dummy;

		// get the name of the input file and open it
		Scanner keybd = new Scanner(System.in);
		System.out.print("Enter the name of the Person file: ");
		String filename = keybd.nextLine();
		File infile = new File(filename);
		Scanner personFile = new Scanner(infile);

		// read file and store all the people in the collection
		build(myPeople, personFile);

		// get people and possibly add to the collection
		do {
			System.out.print("\nEnter age: ");
			//String ssn = keybd.nextLine();
			int age = keybd.nextInt();
			onepeep = new PersonSolution(null, null, age, null,null);
			//System.out.println(onepeep);
			onepeep = myPeople.get(onepeep);
			if (onepeep != null)
				System.out.println("\nThe person is:\n" + onepeep);
			else {
				System.out.println("\nPerson not found\n");
				System.out.println("Add person? (1: yes, 0: no) ");
				again = keybd.nextInt();
				if (again == 1) {

					System.out.print("Enter first name: ");
					fname = keybd.nextLine();
					System.out.print("Enter last name: ");
					lname = keybd.nextLine();
					addPerson(fname, lname, myPeople, keybd);
				}
			}
			System.out.print("\n\nFind another person? (1: yes, 0: no) ");
			again = keybd.nextInt();
			dummy = keybd.nextLine();
		} while (again == 1);

		System.out.println("\nAll the peeps:");
		Iterator<PersonSolution> iter = myPeople.iterator();
		while (iter.hasNext()) {
			onepeep = iter.next();
			System.out.println(onepeep);
		}

	}

	// read Persons from a file and store them in the Collection
	public static void build(CollectionInterface<PersonSolution> mypeeps, Scanner peopleFile) {
		String fname;
		String lname;
		int age;
		String cell;
		String dummy;
		String social;
		PersonSolution onepeep;
		while (peopleFile.hasNext()) {
			fname = peopleFile.nextLine();
			lname = peopleFile.nextLine();
			age = peopleFile.nextInt();
			dummy = peopleFile.nextLine();
			cell = peopleFile.nextLine();
			social = peopleFile.nextLine();
			onepeep = new PersonSolution(fname, lname, age, cell,social);
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
		String social;
		PersonSolution newpeep;
		System.out.print("age: ");
		age = keybd.nextInt();
		dummy = keybd.nextLine();
		System.out.print("cell: ");
		cell = keybd.nextLine();
		System.out.print("Social Security: ");
		social = keybd.nextLine();
		newpeep = new PersonSolution(fname, lname, age, cell,social);
		myPeeps.add(newpeep);
	}


}
