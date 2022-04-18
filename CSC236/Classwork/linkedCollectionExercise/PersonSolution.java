package linkedCollectionExercise;


public class PersonSolution {
    protected String firstname;
    protected String lastname;
    protected int age;
    protected String cell;

    public PersonSolution() { }

    public PersonSolution(String firstname, String lastname, int aa, String cc) {
        this.firstname = firstname;
        this.lastname = lastname;
        age = aa;
        cell = cc;
    }

	// toString method to override method inherited from class Object
    public String toString() {
        String tostr = "Name:    " + firstname + " " + lastname + "\nAge:     " + age
                                          + "\nCell:    " + cell + "\n";
        return tostr;
    }

	// equals method to override method inherited from class Object
	public boolean equals(Object ptest) {

		// if parm is null or is not a PersonSolution object, they are not equal
		if (ptest == null || ptest.getClass() != this.getClass())
			return false;

		// otherwise, check that all fields are equal
		PersonSolution person = (PersonSolution) ptest;
		return this.firstname.equals(person.firstname) &&
							this.lastname.equals(person.lastname);
	}

}
