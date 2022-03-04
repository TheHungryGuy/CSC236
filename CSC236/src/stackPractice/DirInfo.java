package stackPractice;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class DirInfo {

	//ArrayList<String> currDir;
	
	/*
	 * Lab 2 Directions
	 * Read in String from parameter
	 * Use the File class(java.io.File) to print the name of the directory
	 * Print the name of each file and each directory
	 * For every directory contained in the starting directory,
	 * print the directory name and each file within
	 */

	public void printDir(String Path) {
		File homePath = new File(Path); //create file object with the path passed
		System.out.println(); //spacer
		File homePathArr[] = homePath.listFiles(); // create array of files
		//String list = currDir.toString();
		//System.out.println("List: "+list);
		System.out.println(homePath.getAbsolutePath()); //print out current full path 
		for(int i=0;i<homePathArr.length;i++) { //for loop to print out each item in 
			// create File object with the entry and
            // test if it is a file or directory
            File f1 = new File(homePathArr[i].toString());
            if (f1.isFile())
                System.out.print("---" + homePathArr[i].getName()+"\n");
     
            if (f1.isDirectory())
                System.out.print("-" + homePathArr[i].getName()+"\n");
            	//Write method to dive deeper into directory here
            	diveDir(homePathArr[i].getAbsolutePath());
          
		}
	}
	private static void diveDir(String Dir) {
		File currDir = new File(Dir); 
		File currPathArr[] = currDir.listFiles(); // create array of files
		for(int i=0;i<currPathArr.length;i++) {//for loop to print out each item in 
			// create File object with the entry and
            // test if it is a file or directory
			File f1 = new File(currPathArr[i].toString());
            if (f1.isFile())
                System.out.print("---" + currPathArr[i].getName()+"\n");
     
            if (f1.isDirectory())
                System.out.print("-" + currPathArr[i].getName()+"\n");
            	while(stack != empty) {
            		//write stack to push path name to
            	}
            	//Write method to dive deeper into directory here
            		
			
		
			
			
		}
	}
	/*
	 * public String toString() { //to print out arraylist
		
	       String str="";
	       for(int i=0;i<currDir.size();i++) {
	    	   str+="Word: "+ currDir.get(i);
	    
	       }
	       
	       return str;
	*/
	   
	
}
