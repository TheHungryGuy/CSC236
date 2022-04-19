package billboardHot100;

public class Song implements Comparable<Song> {
	
	//attributes of song
	
	protected String url;
	protected Date weekID;
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
	       this.weekID=weekID;
	       this.songName=songName;
	       this.preformerName=preformerName;
	       this.songID=songID;
	       this.instance=instance;
	       this.peakPos=peakPos;
	       this.weeksOnChart=weeksOnChart;
	}
	
	// equals method to override method inherited from class Object
	@Override
	public boolean equals(Object ptest) {

		// if parm is null or is not a Song object, they are not equal
		if (ptest == null || !(ptest instanceof Song))
			return false;

		// otherwise, check that all fields are equal
		Song song = (Song) ptest;
		return this.songID.equalsIgnoreCase(song.songID);
		//might need to change to fields
	}
	
	
	//overridden compareTo method
	//compares Song ID's
	@Override
	public int compareTo(Song comparedSong) {
		return this.songID.compareToIgnoreCase(comparedSong.songID);
	}
	
	// toString method to override method inherited from class Object
	/*	public String toString() { 

			String str="";
			str+="Url: "+url;
			str+=", Date: "+weekID;
			str+=", Song: "+songName;
			str+=", Preformer: "+preformerName;
			str+=", SongID: "+songID;
			str+=", Instance: "+instance;
			str+=", Peak Position: "+peakPos;
			str+=", Weeks on Chart: "+weeksOnChart+"\n";
			return str;
		}
	*/
		public String toString() { 

			String header="";
			header+="Url:\t";
			header+="Date:\t";
			header+="Song:\t";
			header+="Preformer:\t";
			header+="SongID:\t";
			header+="Instance:\t";
			header+="Peak Position:\t";
			header+="Weeks on Chart:\n";
			
			String dataRows="";
			dataRows+="\t"+url;
			dataRows+="\t"+weekID;
			dataRows+="\t"+songName;
			dataRows+="\t"+preformerName;
			dataRows+="\t"+songID;
			dataRows+="\t"+instance;
			dataRows+="\t"+peakPos;
			dataRows+="\t"+weeksOnChart+"\n";
			return dataRows;
		}
		
	//comparator classes???

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
