package billboardHot100;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ClientBillboard100 {

	public static void main(String[] args) {

		try {
			//Create Billboard100 object

			Billboard100 billboard = new Billboard100("hot.stuff.2018.csv");

			// TODO Auto-generated catch block


			Scanner keyboard = new Scanner(System.in);
			boolean quit = false;
			int input = 0;

			while(!quit) {
				System.out.println("Menu : ");
				System.out.println("\t1-Print All Songs");
				System.out.println("\t2-Print songs that were only hot 100 list for more than 12 weeks");
				System.out.println("\t3-Search for Songs in a specific week");
				System.out.println("\t4-Search Artist");
				System.out.println("\t5-Search Song");
				System.out.println("\t6-Print all songs that have more than 1 instace of being on the chart");
				System.out.println("\t7-Print all songs that hit #1");
				System.out.println("\t8-Print all Songs in order by WeekID");
				System.out.println("\t9-Print all Songs in alphabetical order by Song Name");
				System.out.println("\t10-Print all songs in alphabetical order by Performer Name");
				System.out.println("\t11-Exit");

				input = keyboard.nextInt();
				keyboard.nextLine();
				switch(input) {
				case 1: billboard.naturalOrderPrint();continue;
				case 2: billboard.weeksGT12Print();continue;
				case 3: billboard.weekSearch(keyboard);continue;
				case 4: billboard.preformerSearch(keyboard);continue;
				case 5: billboard.songSearch(keyboard);continue;
				case 6: billboard.instanceGT1Print();continue;
				case 7: billboard.topPeakPrint();continue;
				case 8: billboard.weekOrderPrint();continue;
				case 9: billboard.songNameAlphabeticalOrderPrint();continue;
				case 10:billboard.prefomerNameAlphabeticalOrderPrint();continue;
				case 11: quit = true;System.out.println("GoodBye!");continue; 

				default: System.out.println("Error Choice Not Available!");
				System.out.println("Choose a number from the menu!");
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		/*
		 * 
		 * 
		 * 	The data from the songs will be read from a file
		 * 	Client program should read the input file and store the data 
		 *	in you billboard 100 object
		 *
		 *	The program will input the data set and construct a list of songs
		 *	if the list of songs cannot be constructed, the program will displan an appropriate error message and halt
		 *	(use try/catch block)
		 *
		 *	give the user a menu so they can preform all the task stated above
		 *	let user continue until they want to quit
		 *	if the user gives and invalid response  give and error message , and continue
		 *	print error message if no songs match a given request
		 *
		 *	send the output to a file and print message on screen to inform user when data has been written
		 * 
		 * 
		 */




	}

}
