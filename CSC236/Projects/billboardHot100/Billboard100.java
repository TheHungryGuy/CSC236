package billboardHot100;

import java.io.FileWriter;
import java.io.IOException;

public class Billboard100 {

	
	SortedArrayCollection<Song> songList = new SortedArrayCollection<>(20000); //increased cap to hold all songs in list
	
	
	
	//Print all Billboard Hot 100 Songs in the List (use the natural order).
	public void naturalOrderPrint() {
		
	}
	
	//Print all songs in the list that have been on the chart for more than 12 weeks.
	public void weeksGT12Print() {
		
	}
	
	//Display all songs in a specific week: 
	//Prompt the user to enter a month, day and year (remember that the week starts on a Saturday), 
	//then display all songs that made the chart that week
	public void weekSearch() {
		
	}
	
	//Search for a performer: 
	//Prompt the user for a string, 
	//then display all songs in the list that match the performers name (regardless of case)
	public void preformerSearch() {
		
	}
	
	//Search for a song name: 
	//Prompt the user for a string, 
	//then display all songs in the list that match the songs name (regardless of case).
	public void songSearch() {
		
	}
	
	//Print all the songs in the list with an Instance greater than 1.
	public void instanceGT1Print() {
		
	}
	
	//Print all the songs in the list whose peak position is 1.
	public void topPeakPrint() {
		
	}
	
	//Print all Songs in order by WeekID (increasing order). 
	//This is a date. 
	//Hint: need to add a comparator to the Song class as this is not the natural order.
	public void weekOrderPrint() {
		
	}
	
	//Print all Songs in alphabetical order by Song Name. 
	//Hint: need to add a comparator to the Song class as this is not the natural order.
	public void songNameAlphabeticalOrderPrint() {
		
	}
	
	//Print all songs in alphabetical order by Performer Name. 
	//Hint: need to add a comparator to the Song class as this is not the natural order.
	public void prefomerNameAlphabeticalOrderPrint() {
		
	}
	
	//Remember that all of these methods should print to the output file.
	private static void printToOutput(SortedArrayCollection<Song> fileArray) {
		FileWriter writer;
		try {
			writer = new FileWriter("Output.txt");
		for(Song str: fileArray) {
		  writer.write(str + System.lineSeparator());
		}
		writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
		System.out.println(
				"Results in Output.txt file");
	}
	
	
	/*
	 * 
	 * The class Billboard100 will hold the information about all the songs on the BillboardHot100 List. 
	 * A Billboard100 object will contain a SortedArrayCollection of Song objects.
	 * The BillboardHot100 methods will store the Songs in the SortedArrayCollection
	 * and use the SortedArrayCollection methods to access the Songs.
	 * You will need to add an Iterator to the SortedArrayCollection class. Add it as an anonymous inner class.
	 * 
	 */
}
