package pet;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class PetsInfo {

	 public static void main(String[] args) { //Main Method
		 
		 
		 int numPet =10;
		ArrayList<Pets> pet = new ArrayList<Pets>();  //ArrayList to hold Pets added in 
		   readData(pet); //Use private method readData to read in data from file and add into to ArrayList(pet) 
	       
		   System.out.println("All Pet Cats are: \n");
		   printPerticularPets(pet,numPet,"cat");
		   
	       System.out.println("All Pet Dogs are: \n");
		   printPerticularPets(pet,numPet,"dog");

	       System.out.println("All Pets are: \n");
	       printData(pet); //print out all the info from the ArrayList(pet)
	       
	       System.out.println("The Number of pets added to list is " + pet.size()); //print out numbers of pets added to array

	 // hello world
	}
	 
	 //method to print arraylist
	private static void printData(ArrayList<Pets> pet){  
	     for(Pets p:pet)
	           {
	               System.out.println(p);
	           }
	 }
		
	 private static void readData(ArrayList<Pets> pet)
	   {
	       BufferedReader reader;
	       String name,oname,spe,breed;
	       double age,weight;
	       
	       try
	       {
	           reader = new BufferedReader(new FileReader("pets.dat"));
	           String line = reader.readLine();
	           while (line != null)
	           {
	               name=line;
	               // read next line
	               line = reader.readLine();
	               oname=line;
	               // read next line
	               line = reader.readLine();
	               spe=line;
	               // read next line
	               line = reader.readLine();
	               breed=line;
	               // read next line
	               line = reader.readLine();
	               age=Double.parseDouble(line);
	               // read next line
	               line = reader.readLine();
	               weight=Double.parseDouble(line);
	               // read next line
	               pet.add(new Pets(name,oname,spe,breed,age,weight));
	               line = reader.readLine();
	           }
	           reader.close();
	       }
	       catch (IOException e)
	       {
	           System.out.println("File not found");
	       }
	   }
	 
		private static void printPerticularPets(ArrayList<Pets> pet, int numPet, String species)
		{
			for(int i=0;i<numPet;i++)
			{
			if(pet.get(i).isSpecies(species))
			System.out.println(pet.get(i));
			}
		}
	 
	 
	}