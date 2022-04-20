package billboardHot100;
//Antonio Arce CSC236 Data Structures in Java Lab 3
import java.util.Comparator;

public class Song implements Comparable<Song> {

	//attributes of song

	protected String url;
	protected Date date;
	protected String songName;
	protected String preformerName;
	protected String songID;
	protected int instance;
	protected int peakPos;
	protected int weeksOnChart;

	//empty method
	public Song() {
	}

	//public method to build a song
	public Song(String url,Date weekID,String songName, String preformerName, String songID, int instance, int peakPos, int weeksOnChart) {
		this.url=url;
		this.date=weekID;
		this.songName=songName;
		this.preformerName=preformerName;
		this.songID=songID;
		this.instance=instance;
		this.peakPos=peakPos;
		this.weeksOnChart=weeksOnChart;
	}

	//overridden compareTo method
	//compares Song ID's
	@Override
	public int compareTo(Song comparedSong) {
		return this.songID.compareToIgnoreCase(comparedSong.songID);
	}
	public String toString() { 
		String dataRows="";

		String formatStr = "%-45s %-15s %-30s %-55s %-55s %-5s %-5s %-5s%n";
		dataRows = String.format(formatStr, url, date, songName, preformerName, songID, instance, peakPos, weeksOnChart);

		return dataRows;
	}
	public boolean sameDay(Date comparedDate)	{
		boolean same = false;
		if(this.date.compareTo(comparedDate)==0) {
			same =true;
		}
		return same;
	}
	public boolean samePreformer(String pName) {
		boolean samePreformer = false;
		if(this.preformerName.toString().toLowerCase().contains(pName.toLowerCase())) {
			return true;
		}

		return samePreformer;
	}
	public boolean sameSong(String pName) {
		if(this.songName.toString().toLowerCase().contains(pName.toLowerCase())) {
			return true;
		}
		return false;
	}
	public static Comparator<Song> weekComparator() {
		return new Comparator<Song>() {
			public int compare(Song st1, Song st2) {
				return st1.date.compareTo(st2.date);
			}
		};
	}


	public static Comparator<Song> songComparator() {
		return new Comparator<Song>() {
			public int compare(Song st1, Song st2) {
				return st1.songName.compareTo(st2.songName);
			}
		};
	}

	public static Comparator<Song> preformerComparator() {
		return new Comparator<Song>() {
			public int compare(Song st1, Song st2) {
				return st1.preformerName.compareTo(st2.preformerName);
			}
		};
	}

	/*
	 * 
	 * Create methods like boolean performedBy(String performerName), 
	 * which returns true if the parm matches the Performer Name field. 
	 * This is better than creating a get method for the performer
	 * and then doing the comparison in the client code.
	 *
	 * 
	 */

}
