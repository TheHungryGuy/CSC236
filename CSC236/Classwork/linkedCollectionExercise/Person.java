package linkedCollectionExercise;

// class for a person
public class Person {

	private String firstName;
	private String lastName;
	private int age;
	private String cell;

	// default constructor
	Person() {}

	// initializing constructor
	Person(String first, String last, int aa, String cell) {
		firstName = first;
		lastName = last;
		age = aa;
		this.cell = cell;
	}

	@Override
	public boolean equals(Object p) {
		if(!(p instanceof Person)) {
			System.out.println("not instace");
			return false;
		}
		Person per =(Person)p;
		if(!(firstName.equalsIgnoreCase(per.firstName))) {
			return false; 
		}
		if(!(lastName.equalsIgnoreCase(per.lastName))) {
			return false;
		}

		return true;

	}

	public String toString() { //to print out arraylist

		String str="";
		str+="First Name: "+firstName;
		str+="\nLast Name: "+lastName;
		str+="\nAge: "+age;
		str+="\nCell: "+cell+"\n";
		return str;
	}
}