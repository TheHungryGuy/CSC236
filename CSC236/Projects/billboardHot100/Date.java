package billboardHot100;
//Antonio Arce CSC236 Data Structures in Java Lab 3
public class Date implements Comparable<Date> {

	//Attributes of Date
	private int month;
	private int day;
	private int year;
	
	//empty constructor
	public Date() {
	}
	
	//public method for date
	public Date(int month, int day,int year) {
		this.month=month;
		this.day=day;
		this.year=year;
	}

	// equals method to override method inherited from class Object
	public boolean equals(Object ptest) {

		// if parm is null or is not a Date object, they are not equal
		if (ptest == null || !(ptest instanceof Date))
			return false;

		// otherwise, check that all fields are equal
		Date date = (Date) ptest;
		return this.month == date.month &&
							this.day == date.day &&
								this.year == date.year;
		
	}
	
	//compareTo method checks if year and month are the equal
	//else return days subtracted
	@Override
	public int compareTo(Date comparedDate) {
		if(this.year!=comparedDate.year) {
			return this.year-comparedDate.year;
		}
		if(this.month!=comparedDate.month) {
			return this.month-comparedDate.month;
		}
		return this.day-comparedDate.day;	
	}

    public String toString() {
        return month+"/"+day+"/"+year;
    }
	
}
/*
public String toString() { 

	String header="";
	header+="Url:\t";
	header+=", Date:\t";
	header+=", Song:\t";
	header+=", Preformer:\t";
	header+=", SongID:\t";
	header+=", Instance:\t";
	header+=", Peak Position:\t";
	header+=", Weeks on Chart:\n";
	
	String dataRows="";
	dataRows+="\t"+url;
	dataRows+="\t"+weekID;
	dataRows+="\t"+songName;
	dataRows+="\t"+preformerName;
	dataRows+="\t"+songID;
	dataRows+="\t"+instance;
	dataRows+="\t"+peakPos;
	dataRows+="\t"+weeksOnChart+"\n";
	return header+dataRows;
}

*/