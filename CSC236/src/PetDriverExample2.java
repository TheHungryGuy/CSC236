import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

	public class PetDriverExample2 {
	public static void main(String[] args) throws FileNotFoundException {
	Pet []pets=new Pet[25];
	int numPet;
	numPet=readData(pets);
	  
	System.out.println("All Pet Cats are: ");
	pringPerticularPets(pets,numPet,"Cat");
	System.out.println("\nAll Pet Dogs are: ");
	pringPerticularPets(pets,numPet,"Dog");
	System.out.println("\nAll Pets are:");
	printAllPets(pets,numPet);
	  
	}
	public static int readData(Pet []pets) throws FileNotFoundException
			{
				int count=0;
				Scanner scnr=new Scanner(new File("pets.dat"));
				while(scnr.hasNext())
				{
				pets[count]=new Pet(scnr.next(), scnr.next(), scnr.next(), scnr.next(), scnr.nextDouble(), scnr.nextDouble());
				count++;
				}
			return count;
			}

		private static void printAllPets(Pet[] pets, int numPet) {
		for(int i=0;i<numPet;i++)
		{
		System.out.println(pets[i]);
		}
		}

	private static void pringPerticularPets(Pet[] pets, int numPet, String species)
	{
		for(int i=0;i<numPet;i++)
		{
		if(pets[i].isSpecies(species))
		System.out.println(pets[i]);
		}
	}
  
  
}