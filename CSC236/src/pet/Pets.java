package pet;

public class Pets {

	//attributes
		private String petName;
		private String ownerName;
		private String species;
		private String breed;
		
		private double age;
		private double weight;
		
		
		
	//default constructor
		public Pets() {
			//don't do anything here
			//bec, it's just an empty object...
		}
		
		
		
	/*	public Pets(String initPName, String initOName, 
				String initSpecies, String initBreed, double initAge, double initWeight){
			
				petName = initPName;
				ownerName = initOName;
				species = initSpecies;
				breed = initBreed;
				age = initAge;
				weight = initWeight;
			}
	*/	
		// next constructor is equivalent to blocked out constructor above
		public Pets(String petName,String owner,String species,String breed,double age,double weight)
		   {
		       this.petName=petName;
		       this.ownerName=owner;
		       this.species=species;
		       this.breed=breed;
		       this.age=age;
		       this.weight=weight;
			}
			
	//methods
		public boolean isSpecies(String parm) {  //to return true or false if the species match
				return this.species.equals(parm);
			}
		
		public String toString() { //to print out arraylist
			
		       String str="";
		       str+="Pet Name: "+petName;
		       str+="\nOwner Name: "+ownerName;
		       str+="\nSpecies: "+species;
		       str+="\nBreed: "+breed;
		       str+="\nAge: "+age;
		       str+="\nWeight: "+weight+"\n";
		       return str;
		}

		
		
}
