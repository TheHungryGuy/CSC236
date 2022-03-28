package queueExercise;



public class Person {

	//attributes
	private String name;	
	private int age;
	private String cellNum;


	//default constructor
	public Person() {
		//don't do anything here
		//bec, it's just an empty object...
	}

	public Person(String name, int age, String cellNum)
	{
		this.name = name;
		this.age= age;
		this.cellNum = cellNum;

	}

	public boolean samePerson(String name, int age, String cellNum) {  //to return true or false if the species match
		boolean same = false;
		if (this.name.equals(name)) {
			if(this.age == age) {
				if(this.cellNum.equals(cellNum)) {
					same = true;
				}
			}
		}


		return same;
	}

	public boolean nameStartsWith(char name) {
		
		
		if(Character.compare(name, this.name.charAt(0)) == 0) {
			return true;
		}
		
		


		return false;
	}

	public String toString() { //to print out arraylist

		String str="";
		str+="Name: "+name;
		str+="\nAge: "+age;
		str+="\nCell Number: "+cellNum+"\n";
		return str;
	}

}
