package pet;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

	public class PetDriverExample2 {
	public static void main(String[] args) throws FileNotFoundException {
	Pets []pet=new Pets[25];
	int numPet;
	numPet=readData(pet);
	  
	System.out.println("All Pet Cats are: ");
	pringPerticularPets(pet,numPet,"Cat");
	System.out.println("\nAll Pet Dogs are: ");
	pringPerticularPets(pet,numPet,"Dog");
	System.out.println("\nAll Pets are:");
	printAllPets(pet,numPet);
	  
	}
	public static int readData(Pets []pet) throws FileNotFoundException
			{
				int count=0;
				Scanner scnr=new Scanner(new File("pets.dat"));
				while(scnr.hasNext())
				{
				pet[count]=new Pets(scnr.next(), scnr.next(), scnr.next(), scnr.next(), scnr.nextDouble(), scnr.nextDouble());
				count++;
				}
			return count;
			}

		private static void printAllPets(Pets[] pets, int numPet) {
		for(int i=0;i<numPet;i++)
		{
		System.out.println(pets[i]);
		}
		}

	private static void pringPerticularPets(Pets[] pets, int numPet, String species)
	{
		for(int i=0;i<numPet;i++)
		{
		if(pets[i].isSpecies(species))
		System.out.println(pets[i]);
		}
	}
  
  
}