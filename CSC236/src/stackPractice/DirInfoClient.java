package stackPractice;

import java.util.Scanner;

public class DirInfoClient {

	public static void main(String[] args) {
		
		DirInfo Dir = new DirInfo(); //Creates an obj of class DirInfo
		String Path =""; //String to hold home path 
		
		System.out.println("Enter the path of the directory:"); //Prompt User for path 
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in); //Create Scanner Obj
		Path = input.nextLine(); //next line stored in String
		Dir.printDir(Path); 
		
		/*
		 * Insert method from Dir
		 * to print out the folders
		 * and files of each 
		 */
		
		
	}

}
