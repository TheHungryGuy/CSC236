package billboardHot100;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Billboard100 {


	SortedArrayCollection<Song> songList = new SortedArrayCollection<>(20000); //increased cap to hold all songs in list



	public Billboard100(String filename)throws FileNotFoundException, IOException {
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader(filename));

		String line = reader.readLine();
		while(line != null) {
			line = reader.readLine();
			String[]tmp = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
			String[]datetmp = tmp[1].split("/", 0); //needed to split the date up to add new date in

			//converting from string to int

			int m= Integer.parseInt(datetmp[0]);
			int d= Integer.parseInt(datetmp[1]);
			int y= Integer.parseInt(datetmp[2]);
			Date newday;
			newday= new Date(m,d,y);
			System.out.println(newday);
			//converted instance,peakPos,and weeksonchart to int
			int ins= Integer.parseInt(tmp[5]);
			int pos= Integer.parseInt(tmp[6]);
			int weeks= Integer.parseInt(tmp[7]);
			System.out.print(ins);System.out.print(pos);System.out.println(weeks);
			for(int i=0; i<tmp.length;i++) {
				System.out.println(i+": "+tmp[i]);

			}

			//add in song to song list
			Song hotsong;
			hotsong = new Song(tmp[0],newday,tmp[2],tmp[3],tmp[4],ins,pos,weeks);
			songList.add(hotsong);
			System.out.println("sucess?");

		}
	}

	//Print all Billboard Hot 100 Songs in the List (use the natural order).
	public void naturalOrderPrint() {
		for(Song s: songList) {
			System.out.println(s);
		}
	}

	//Print all songs in the list that have been on the chart for more than 12 weeks.
	public void weeksGT12Print() {
		for(Song s: songList) {
			if(s.weeksOnChart<12) {
				System.out.println(s);
			}
		}
	}

	//Display all songs in a specific week: 
	//Prompt the user to enter a month, day and year (remember that the week starts on a Saturday), 
	//then display all songs that made the chart that week
	public void weekSearch(Scanner keyboard) {
		boolean loop = true;
		while(loop) {
			System.out.println("Enter a month 1-12");
			int m = keyboard.nextInt();
			keyboard.nextLine();
			System.out.println("Enter a day 1-31");
			int d = keyboard.nextInt();
			keyboard.nextLine();
			System.out.println("Enter a year 2018-2021");
			int y = keyboard.nextInt();
			keyboard.nextLine();

			//check if date lands on Saturdays
			//if not throw error and ask for another date that is a saturday
			Date sat = new Date(m,d,y);
			Song check =new Song(null, sat, null, null, null, y, y, y);
			check = songList.get(check);
			if(check==null) {
				System.out.println("Incorrect Date Entered");
			}
			else {
				loop = false;
				for(Song s:songList) {
					if(s.weekID.equals(sat))
					System.out.println(s);
				}
			}
		}
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
	private void write()throws IOException{
		FileWriter writer;
		String header="";
		header+="Url:\t";
		header+="Date:\t";
		header+="Song:\t";
		header+="Preformer:\t";
		header+="SongID:\t";
		header+="Instance:\t";
		header+="Peak Position:\t";
		header+="Weeks on Chart:\n";

		try {
			writer = new FileWriter("Output.txt");
			writer.write(header);
			for(Song str: songList) {
				writer.write(str.toString());
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
