package comparableExercise;
import java.util.Comparator;

public class PersonSolution implements Comparable<PersonSolution> {
    protected String firstname;
    protected String lastname;
    protected int age;
    protected String cell;
    protected String social;

    public PersonSolution() { }

    public PersonSolution(String firstname, String lastname, int aa, String cc, String social) {
        this.firstname = firstname;
        this.lastname = lastname;
        age = aa;
        cell = cc;
        this.social = social;
    }

	// toString method to override method inherited from class Object
	public String toString() { //to print out arraylist

		String str="";
		str+="First Name: "+firstname;
		str+="\nLast Name: "+lastname;
		str+="\nAge: "+age;
		str+="\nCell: "+cell;
		str+="\nSocial Security: "+social+"\n";
		return str;
	}

	// equals method to override method inherited from class Object
	public boolean equals(Object ptest) {

		// if parm is null or is not a PersonSolution object, they are not equal
		if (ptest == null || !(ptest instanceof PersonSolution))
			return false;

		// otherwise, check that all fields are equal
		PersonSolution person = (PersonSolution) ptest;
		return this.firstname.equals(person.firstname) &&
							this.lastname.equals(person.lastname);
	}

	@Override
	public int compareTo(PersonSolution comparedPerson) {
		if(this.lastname.compareTo(comparedPerson.lastname)==0) { //last names are the same
			//compare first names
			return this.firstname.compareTo(comparedPerson.firstname);
		}
		else if(this.lastname.compareTo(comparedPerson.lastname)>0)
		{
			return 1;
		}
		else
		return -1;
	}

	
	
	
	public static Comparator<PersonSolution> ssnComparator() {
		return new Comparator<PersonSolution>() {
			public int compare(PersonSolution per1, PersonSolution per2) {
				if (per1.social.compareTo(per2.social)>0)
					return 1;
				else if (per1.social.compareTo(per2.social)<0)
					return -1;
				else return 0;
			}
		};

	}
	
	public static Comparator<PersonSolution> ageComparator() {
		return new Comparator<PersonSolution>() {
			public int compare(PersonSolution per1, PersonSolution per2) {
			if (per1.age>per2.age)
				return 1;
			else if (per1.age<per2.age)
				return -1;
			else return 0;
			}
		};

	}
}
