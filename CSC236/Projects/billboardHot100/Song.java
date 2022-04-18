package billboardHot100;

public class Song implements Comparable<Song> {
	
	//attributes of song
	
	private String url;
	private Date weekID;
	private String songName;
	private String preformerName;
	private String songID;
	private int instance;
	private int peakPos;
	private int weeksOnChart;

	public Song() {
		//empty method
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
	public boolean equals(Object ptest) {

		// if parm is null or is not a Song object, they are not equal
		if (ptest == null || !(ptest instanceof Song))
			return false;

		// otherwise, check that all fields are equal
		Song song = (Song) ptest;
		return this.songID.equals(song.songID) &&
							this.songName.equals(song.songName);
		//might need to change to just one field
	}
	
	@Override
	public int compareTo(Song comparedSong) {
		if(this.songName.compareTo(comparedSong.songName)==0) { //last names are the same
			//compare first names
			return this.songID.compareTo(comparedSong.songID);
		}
		else if(this.songName.compareTo(comparedSong.songName)>0)
		{
			return 1;
		}
		else
		return -1;
	}
	
	//comparator classes???
	
	
}
