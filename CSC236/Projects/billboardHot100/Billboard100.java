package billboardHot100;
//Antonio Arce CSC236 Data Structures in Java Lab 3
import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Billboard100 {
	SortedArrayCollection<Song> songList = new SortedArrayCollection<>(20000); //increased cap to hold all songs in list
	SortedArrayCollection<Song> preformerList = new SortedArrayCollection<>(20000,Song.preformerComparator());
	SortedArrayCollection<Song> songNameList = new SortedArrayCollection<>(20000,Song.songComparator());
	SortedArrayCollection<Song> weekList = new SortedArrayCollection<>(20000,Song.weekComparator());
	public Billboard100(String filename)throws FileNotFoundException, IOException {
		//method takes in filename as a parameter
		//Adds to the songList

		//call reader to read in file
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader(filename));

		String line = reader.readLine();
		line = reader.readLine();  //read line twice to skip first line
		while(line != null) {
			//continue until file is fully read
			//split each line into a string array
			String[]tmp = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
			String[]datetmp = tmp[1].split("/", 0); //needed to split the date up to add new date in

			//converting from string to int
			int m= Integer.parseInt(datetmp[0]);
			int d= Integer.parseInt(datetmp[1]);
			int y= Integer.parseInt(datetmp[2]);
			Date newday;
			newday= new Date(m,d,y);

			//converted instance,peakPos,and weeksonchart to int
			int ins= Integer.parseInt(tmp[5]);
			int pos= Integer.parseInt(tmp[6]);
			int weeks= Integer.parseInt(tmp[7]);

			//add in song to song list
			Song hotsong //temporary new song to add to list
			= new Song(tmp[0],newday,tmp[2],tmp[3],tmp[4],ins,pos,weeks);
			songList.add(hotsong);
			preformerList.add(hotsong);
			songNameList
			.add(hotsong);
			weekList.add(hotsong);
			//read next line
			line = reader.readLine();
		}
	}

	//Print all Billboard Hot 100 Songs in the List (use the natural order).
	public void naturalOrderPrint() {
		try {
			writeAll(songList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Print all songs in the list that have been on the chart for more than 12 weeks.
	public void weeksGT12Print() {
		newWriter();
		for(Song s: songList) {
			if(s.weeksOnChart>12) {
				appendWriter(s);
			}
		}
	}

	//Display all songs in a specific week: 
	//Prompt the user to enter a month, day and year (remember that the week starts on a Saturday), 
	//then display all songs that made the chart that week
	public void weekSearch(Scanner keyboard) {
		boolean sameday = false;
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
		for(Song s:songList) {
			if(s.sameDay(sat)) {
				if(!sameday) {
					newWriter();
				}
				appendWriter(s);
				sameday = true;
			}
		}
		if(!sameday) {
			System.out.println("Date entered is not a saturday.");
		}
	}

	//Search for a performer: 
	//Prompt the user for a string, 
	//then display all songs in the list that match the performers name (regardless of case)
	public void preformerSearch(Scanner keyboard) {

		System.out.println("Enter a preformer name");
		String input = keyboard.nextLine();
		boolean sameArtist = false;
		for(Song s:songList ) {
			if(s.samePreformer(input)) {
				if(!sameArtist) {
					newWriter();
				}
				appendWriter(s);
				sameArtist = true;
			}
		}
		if (!sameArtist) {
			System.out.println("Artist Not Found!");
		}
	}

	//Search for a song name: 
	//Prompt the user for a string, 
	//then display all songs in the list that match the songs name (regardless of case).
	public void songSearch(Scanner keyboard) {
		System.out.println("Enter a song name");
		String input = keyboard.nextLine();
		boolean sameSongs = false;
		for(Song s:songList ) {
			if(s.sameSong(input)) {
				if(!sameSongs) {
					newWriter();
				}
				appendWriter(s);
				sameSongs = true;
			}
		}
		if (!sameSongs) {
			System.out.println("Song Not Found!");
		}
	}


	//Print all the songs in the list with an Instance greater than 1.
	public void instanceGT1Print() {
		newWriter();
		for(Song s: songList) {
			if(s.instance>1) {
				appendWriter(s);
			}
		}
	}

	//Print all the songs in the list whose peak position is 1.
	public void topPeakPrint() {

		newWriter();
		for(Song s: songList) {
			if(s.peakPos==1) {
				appendWriter(s);
			}
		}
	}

	//Print all Songs in order by WeekID (increasing order). 
	//This is a date. 
	//Hint: need to add a comparator to the Song class as this is not the natural order.
	public void weekOrderPrint() {
		try {
			writeAll(weekList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Print all Songs in alphabetical order by Song Name. 
	//Hint: need to add a comparator to the Song class as this is not the natural order.
	public void songNameAlphabeticalOrderPrint() {
		try {
			writeAll(songNameList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Print all songs in alphabetical order by Performer Name. 
	//Hint: need to add a comparator to the Song class as this is not the natural order.
	public void prefomerNameAlphabeticalOrderPrint() {
		try {
			writeAll(preformerList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Remember that all of these methods should print to the output file.
	private void writeAll(SortedArrayCollection<Song> list)throws IOException{
		FileWriter writer;


		try {
			writer = new FileWriter("Output.txt");
			writer.write(header());
			for(Song str: list) {
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
	//newWriter clears the file and appends the header
	private void newWriter() {
		try{

			FileWriter writeNew = new FileWriter("output.txt");
			writeNew.write(header());
			writeNew.close();


		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Data in output.txt");

	}
	//appendWriter is used in combination with new writer
	//this allows each line to be added to the file without adding the header each time
	private <T> void appendWriter(T songs) {
		try{

			FileWriter appendOld = new FileWriter("output.txt",true);
			appendOld.write(songs.toString());
			appendOld.close();

		}catch(Exception e){
			e.printStackTrace();
		}

	}
	//string that contains the first row
	private String header() {
		String dataRows="";
		String formatStr = "%-51s %-16s %-29s %-55s %-51s %-5s %-5s %-5s%n";
		dataRows = String.format(formatStr, "URL:", "Date:", "Song:", "Preformer:", "songID:", "Instance:", "PeakPos:", "WeeksOnChart:");

		return dataRows;
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
