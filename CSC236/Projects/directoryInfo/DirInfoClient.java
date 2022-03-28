package directoryInfo;
//Antonio Arce CSC236 Data Structures in Java Lab 1


import java.util.Scanner;
public class DirInfoClient {

	public static void main(String[] args) {

		DirInfo Dir = new DirInfo(); //Creates an obj of class DirInfo
		String path =""; //String to hold home path 
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in); //Create Scanner Obj

		//try-catch block in case directory does not exist
		while(true) {
			try{
				System.out.println("Enter the path of the directory (E.g '/zero:')"); //Prompt User for path 
				path = input.nextLine(); //next line stored in String
				Dir.printDir(path); //calls print directory to print directory of input path
				break; //breaks while loop if no exception is caught
			}
			catch(Exception e) {
				System.out.println("Directory not found!");  //alerts of error
				continue; //continues loop until directory is found
			}

		}

	}

}
